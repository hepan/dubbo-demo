package io.github.hepan.docker.demo.messages.api.service;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/16 10:27
 **/
public interface MessageServiceInterface {

    /**
     * 发送邮件验证信息
     * @param emailAddress
     * @return
     */
    Integer sendEmail(String emailAddress);

    /**
     * 发送短信验证信息
     * @param phoneNumber
     * @return
     */
    Integer sendMessage(String phoneNumber);

    /**
     * 获取验证码
     * @param key
     * @return 验证码，超时返回null
     */
    String getVerifyCode(String key);
}
