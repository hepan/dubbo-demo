package io.github.hepan.docker.demo.user.edge.web;

import io.github.hepan.docker.demo.user.api.model.UserInfo;
import io.github.hepan.docker.demo.user.edge.response.Response;
import io.github.hepan.docker.demo.user.edge.service.UserEdgeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/5 08:48
 **/
@RestController
@RequestMapping("/user")
public class UserEdgeController {
    @Autowired
    private UserEdgeServiceInterface userEdgeServiceInterface;


    /**
     * 注册用户
     *
     * @param userInfo
     * @return
     */
    @PostMapping()
    public Response registered(UserInfo userInfo) {
        return userEdgeServiceInterface.registeredUser(userInfo);
    }

    @PostMapping("/sendVerifyCode")
    public Response sendVerifyCode(String phone){
        return userEdgeServiceInterface.sendVerifyCode(phone);
    }


    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */

    @PostMapping("/login")
    public boolean login(String username, String password) {
        return userEdgeServiceInterface.login(username, password);
    }
}
