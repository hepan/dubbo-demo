package io.github.hepan.docker.demo.message.service;

import cn.hutool.core.util.RandomUtil;
import io.github.hepan.docker.demo.messages.api.service.MessageServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/16 20:00
 **/
@Slf4j
@Service
@Component
public class MessageServiceImpl implements MessageServiceInterface {
    @Override
    public Integer sendEmail(String emailAddress) {
        Integer code = RandomUtil.randomInt(100000, 999999);
        log.info("send email to 「{}」,verify code is 「{}」", emailAddress, code);
        return code;

    }

    @Override
    public Integer sendMessage(String phoneNumber) {
        Integer code = RandomUtil.randomInt(100000, 999999);
        log.info("send message to 「{}」,verify code is 「{}」", phoneNumber, code);
        return code;
    }

    @Override
    public String getVerifyCode(String key) {
        return null;
    }
}
