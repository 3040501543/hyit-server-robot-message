package com.tianyuan.hyitrobot.project.feign;

import com.tianyuan.hyitrobot.project.feign.constants.ServiceConstants;
import com.tianyuan.hyitrobot.project.feign.vo.EmptyVo;
import com.tianyuan.hyitrobot.project.feign.vo.ResponseModel;
import com.tianyuan.hyitrobot.project.robot.param.RobotDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author wangqi
 * @Date 2022/3/25 14:07
 * @Version 1.0
 */

@FeignClient(name = ServiceConstants.EXAMINE_SERVICE_PREFIX, path = ServiceConstants.EXAMINE_SERVICE_PREFIX + "/robot")
public interface IrSafeCheckErrDescFeign {
    @PostMapping("/errCommit")
    @ApiOperation(value = "隐患提报", notes = "隐患提报")
    public ResponseModel<EmptyVo> errCommit(@RequestBody RobotDto dto);
}