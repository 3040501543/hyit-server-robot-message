package com.tianyuan.hyitrobot.project.feign.vo;

import com.tianyuan.hyitrobot.project.feign.constants.HttpStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: ResponseModel
 * @Auther: Xub
 * @Date: 2020/5/27 09:25
 * @Description:
 */
@Data
@ApiModel(description = "返回对象")
public class ResponseModel<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "状态码", name = "code")
    private int code;

    @ApiModelProperty(value = "消息内容", name = "msg")
    private String msg;

    @ApiModelProperty(value = "数据对象", name = "data")
    private T data;
    /**
     * 生成时间戳
     */
    @ApiModelProperty("时间戳")
    private Long timestamp = System.currentTimeMillis();

    /**
     * 是否成功
     */
    @ApiModelProperty("是否成功")
    private Boolean success = true;

    public ResponseModel() {
        this.code = HttpStatus.SUCCESS;
    }


    public void setCode(int code) {
        this.code = code;
        this.success = code == 200;
    }
}
