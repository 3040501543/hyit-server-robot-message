package com.tianyuan.hyitrobot.Utils;

import com.alibaba.fastjson.JSONObject;
import com.tianyuan.hyitrobot.project.feign.IrSafeCheckErrDescFeign;
import com.tianyuan.hyitrobot.project.robot.param.RobotDto;
import com.tianyuan.hyitrobot.project.robot.param.WechatMsgDto;
import com.tianyuan.hyitrobot.project.robot.service.impl.SendWeChatMessageZKServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

@Component
public class SocketServer {

    @Autowired
    private IrSafeCheckErrDescFeign irSafeCheckErrDescFeign;

    private static SocketServer socketServer ;

    @PostConstruct
    public void init() {
        // 把 类本身 赋予变量  myClass
        socketServer = this;
        // 把 初始化加载的 nettyMeterDataService 属性 赋值给本类
        socketServer.irSafeCheckErrDescFeign = this.irSafeCheckErrDescFeign;

    }

    public static void main(String[] args)throws IOException {
        //监听
        ServerSocket server = new ServerSocket(8527);

        System.out.println("服务器端准备就绪：");
        System.out.println("服务器信息：" + server.getInetAddress()+"Port:" + server.getLocalPort());

        //等待客户端连接
        for (;;){
            Socket client = server.accept();
            //客户端构建异步线程
            ClientHandler clientHandler = new ClientHandler(client);
            clientHandler.start();
        }
    }

    /*
    * 客户端
    * */
    private static  class ClientHandler extends Thread {
        private  Socket socket;
        private boolean flag = true;
        public ClientHandler(Socket socket){
            this.socket = socket;
        }

        @Override
        @PostConstruct
        public void run() {
            super.run();
            System.out.println("新客户端连接：" + socket.getInetAddress() + " | port:"+ socket.getPort());
            try {
                //得到打印流 用于数据输出服务器回送数据使用
                PrintStream socketOutput = new PrintStream(socket.getOutputStream());
                //得到输入流 用于接收数据
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                do {
                    //客户端拿到一条数据
                    String str = socketInput.readLine();
                    if(str!=null)
                    {
                        System.out.println("收到客户端发送数据："+str);
                        Map map = JSONObject.parseObject(str, Map.class);
                        //使用entrySet方式
                        for (Object entrySetOj : map.entrySet()) {
                            System.out.println("使用entrySet方式得到的key是：" + ((Map.Entry) entrySetOj).getKey() + "，" + "value是：" + ((Map.Entry) entrySetOj).getValue());
                            if (((Map.Entry) entrySetOj).getKey().equals("type")) {
                                if (((Map.Entry) entrySetOj).getValue().equals("1")) {
                                    // TODO: 2022/12/27 feign调用问题
                                    RobotDto vo = JSONObject.parseObject(str,RobotDto.class);
                                    socketServer.irSafeCheckErrDescFeign.errCommit(vo);
                                } else if (((Map.Entry) entrySetOj).getValue().equals("2")) {//企业微信
                                    WechatMsgDto vo = JSONObject.parseObject(str, WechatMsgDto.class);
                                    vo.setType("wechat");
                                    SendWeChatMessageZKServiceImpl impl = new SendWeChatMessageZKServiceImpl();
                                    impl.sendWechatMessageZK(vo);
                                }
                            }
                        }
                    }
//                    if ("bye".equalsIgnoreCase(str)){
//                        flag = false;
//                        //回送
//                        socketOutput.println("bye");
//                    }else {
//                        //打印到屏幕
//                        System.out.println(str);
//                        socketOutput.println("回送" + str.length());
//                    }
                }while (flag);
                socketInput.close();;
                socketOutput.close();
            }catch (Exception e){
                System.out.println("连接异常断开");
                System.out.println(e);
            }finally {
                //连接关闭
                try {
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            System.out.println("客户端已退出" + socket.getInetAddress() + "p:" + socket.getPort());
        }
    }
}