package com.tianyuan.hyitrobot.project.robot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WechatVo {

    private String toUser;

    private String toParty;

    private String toTag;

    private String content;

    private String safe;

    private String corpId;

    private String corpSecret;

    private String agentId;

    private String type;
}
