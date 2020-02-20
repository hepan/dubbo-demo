package io.github.hepan.docker.demo.user.edge.service;

import io.github.hepan.docker.demo.user.api.model.UserInfo;
import io.github.hepan.docker.demo.user.edge.response.Response;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/9 23:13
 **/
public interface UserEdgeServiceInterface {

    /**
     * 注册用户
     *
     * @param userInfo 用户信息
     * @return response
     */
    Response registeredUser(UserInfo userInfo);


    /**
     * 验证code码
     * @param code
     * @return
     */
    boolean verifyCode(String code);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    boolean login(String username ,String password);

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    Response sendVerifyCode(String phone);
}
