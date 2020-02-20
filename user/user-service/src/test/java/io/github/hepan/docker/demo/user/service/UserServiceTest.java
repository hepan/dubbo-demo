package io.github.hepan.docker.demo.user.service;

import io.github.hepan.docker.demo.user.api.exception.UserRegisteredException;
import io.github.hepan.docker.demo.user.api.model.UserInfo;
import io.github.hepan.docker.demo.user.api.service.UserServiceInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/4 14:48
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserServiceInterface userServiceInterface;

    @Test
    public void testGetUserByLoginName() {
        userServiceInterface.getUserByLoginName("hepan");
    }

    @Test
    public void testInsert() throws UserRegisteredException {
        userServiceInterface.registeredUser(UserInfo.builder()
                .loginName("hepan1")
                .password("panpan")
                .email("hepan@abc.com")
                .phone("1234444")
                .realName("panpan1")
                .build());
    }

}
