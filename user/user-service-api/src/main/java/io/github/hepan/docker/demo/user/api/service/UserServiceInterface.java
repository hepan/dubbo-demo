package io.github.hepan.docker.demo.user.api.service;

import io.github.hepan.docker.demo.user.api.exception.UserRegisteredException;
import io.github.hepan.docker.demo.user.api.model.UserInfo;

import java.util.List;

/**
 * @author hp
 * @describe 用户对外接口
 * @createTime 2020/2/4 11:36
 **/
public interface UserServiceInterface {

    /**
     * 根据loginName获取用户信息
     *
     * @param loginName
     * @return
     */
    UserInfo getUserByLoginName(String loginName);

    /**
     * 根据用户id获取用户信息
     *
     * @param id
     * @return
     */
    UserInfo getUserById(String id);

    /**
     * 根据user查询user列表
     *
     * @param user
     * @return
     */
    List<UserInfo> getUser(UserInfo user);


    /**
     * 注册用户
     * @param userInfo 用户基本信息
     * @throws UserRegisteredException
     */
     void registeredUser(UserInfo userInfo) throws UserRegisteredException;
}
