package com.tianyuan.hyitrobot;

import com.tianyuan.hyitrobot.Utils.SocketServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.io.IOException;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class HyitRobotApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(HyitRobotApplication.class, args);
        SocketServer.main(args);
    }

}
