package com.tianyuan.hyitrobot.project.robot.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RobotDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "隐患描述")
    private String errDesc;

    @ApiModelProperty(value = "检查时间")
    private Date checkDate;

    @ApiModelProperty(value = "部门编码")
    private String deptCode;

    @ApiModelProperty(value = "组织编码")
    private String orgCode;

    @ApiModelProperty(value = "必填。隐患来源")
    private String errSource;

    @ApiModelProperty(value = "非必填。设备位号，文本")
    private String equipmentNo;


}
