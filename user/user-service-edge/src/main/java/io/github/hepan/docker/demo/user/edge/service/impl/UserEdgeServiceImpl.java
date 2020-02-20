package io.github.hepan.docker.demo.user.edge.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.github.hepan.docker.demo.messages.api.service.MessageServiceInterface;
import io.github.hepan.docker.demo.user.api.model.UserInfo;
import io.github.hepan.docker.demo.user.api.service.UserServiceInterface;
import io.github.hepan.docker.demo.user.edge.config.StaticConstant;
import io.github.hepan.docker.demo.user.edge.model.VerifyCodeBO;
import io.github.hepan.docker.demo.user.edge.redis.RedisClient;
import io.github.hepan.docker.demo.user.edge.response.Response;
import io.github.hepan.docker.demo.user.edge.service.UserEdgeServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @author hp
 * @describe
 * @createTime 2020/2/9 23:14
 **/
@Service
@Slf4j
public class UserEdgeServiceImpl implements UserEdgeServiceInterface {


    @Autowired
    private RedisClient redisClient;

    @Reference
    UserServiceInterface userServiceInterface;

    @Reference
    MessageServiceInterface messageServiceInterface;

    @Override
    public Response registeredUser(UserInfo userInfo) {
        try {
            userServiceInterface.registeredUser(userInfo);
            if (StrUtil.isNotEmpty(userInfo.getEmail())) {
                messageServiceInterface.sendEmail(userInfo.getEmail());
            } else if (StrUtil.isNotEmpty(userInfo.getPhone())) {
                messageServiceInterface.sendMessage(userInfo.getPhone());
            }
        } catch (Exception e) {
            return Response.exception(e);
        }


        redisClient.expire(userInfo.getPhone(), 300);

        return Response.SUCCESS;
    }

    @Override
    public boolean verifyCode(String code) {
        log.info("verify code ---->{}", code);


        return false;
    }

    @Override
    public boolean login(String username, String password) {
        log.info("login  ---->{},{}", username, password);
        return false;
    }

    @Override
    public Response sendVerifyCode(String phone) {

        //1 查看缓存中是否已经存储了此验证码
        //2 已经存了说明已经发送过验证码，且没有到下一次的冷却时间
        //3 如果不存在则将 phone做未key，code作为value存入redis，并设置过期时长未30s
        //思考，为什么业务系统来缓存验证码，而不是message服务来缓？
        //hp的回答：如果A,B连个服务都有发验证码的业务，那么A发送后，B在冷却期间就会发送失败。

        VerifyCodeBO codeBO = redisClient.get(StaticConstant.REDIS_PHONE_CODE_HEADER + phone);

        if (codeBO != null && DateUtil.offsetSecond(new Date(), StaticConstant.VERIFY_CODE_CD_SECOND).isAfter(codeBO.getStartTime())) {
            return Response.PHONE_CODE_MESSAGE_CD;
        }

        Integer code = messageServiceInterface.sendMessage(phone);

        redisClient.set(StaticConstant.REDIS_PHONE_CODE_HEADER + phone,
                VerifyCodeBO.builder().code(code).startTime(new Date()),
                StaticConstant.VERIFY_CODE_EXPIRED_SECOND);

        return Response.SUCCESS;
    }
}
