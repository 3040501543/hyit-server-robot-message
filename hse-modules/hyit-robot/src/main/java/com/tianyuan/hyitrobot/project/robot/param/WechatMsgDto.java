package com.tianyuan.hyitrobot.project.robot.param;

import lombok.Data;

/**
 * @Author xubin
 * @Date 2022/11/24 16:08
 * @Version
 **/

@Data
public class WechatMsgDto {
    /**
     * "companyCode":"test",
     * "companyName":"测试",
     * "content":"9月18日第一条信息",
     * "key":"sendemailkey",
     * "title":"",
     * "type""wechat",
     * "userCodes":["L1808011"]
     */

    String companyCode;
    String companyName;
    String content;
    String key;
    String title;
    String type;
    String[] userCodes;

}
