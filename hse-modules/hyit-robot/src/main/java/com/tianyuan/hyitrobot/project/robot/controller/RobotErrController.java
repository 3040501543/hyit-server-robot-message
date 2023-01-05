package com.tianyuan.hyitrobot.project.robot.controller;

import com.tianyuan.hyitrobot.project.feign.IrSafeCheckErrDescFeign;
import com.tianyuan.hyitrobot.project.feign.constants.HttpStatus;
import com.tianyuan.hyitrobot.project.feign.vo.EmptyVo;
import com.tianyuan.hyitrobot.project.feign.vo.ResponseModel;
import com.tianyuan.hyitrobot.project.robot.param.RobotDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "机器人巡检隐患")
@RequestMapping("/robot")
public class RobotErrController {

//    @Autowired
//    private IrSafeCheckErrDescFeign safeCheckErrDescService;
//
//    @PostMapping("/errCommit")
//    @ApiOperation(value = "隐患提报", notes = "隐患提报")
//    public ResponseModel<EmptyVo> errCommit(@RequestBody RobotDto dto) {
//        ResponseModel<EmptyVo> responseModel = new ResponseModel<>();
//        Boolean commit = safeCheckErrDescService.errCommit(dto).getSuccess();
//        responseModel.setCode(commit ? HttpStatus.SUCCESS : HttpStatus.ERROR);
//        responseModel.setMsg(commit ? "操作成功" : "操作失败");
//        return responseModel;
//    }
}
