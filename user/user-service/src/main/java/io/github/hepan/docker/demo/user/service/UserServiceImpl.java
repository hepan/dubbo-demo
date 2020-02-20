package io.github.hepan.docker.demo.user.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.MD5;
import io.github.hepan.docker.demo.user.api.exception.UserRegisteredException;
import io.github.hepan.docker.demo.user.api.model.UserInfo;
import io.github.hepan.docker.demo.user.api.service.UserServiceInterface;
import io.github.hepan.docker.demo.user.dao.UserDao;
import io.github.hepan.docker.demo.user.model.UserPO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/4 14:32
 **/
@Service
@Component
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserDao userDao;

    @Override
    public UserInfo getUserByLoginName(String loginName) {
        UserPO userPO = userDao.createLambdaQuery().andEq(UserPO::getLoginName, loginName).single();

        return transformUser(userPO);
    }

    @Override
    public UserInfo getUserById(String id) {
        return null;
    }

    @Override
    public List<UserInfo> getUser(UserInfo user) {
        return null;
    }

    @Override
    public void registeredUser(UserInfo userInfo) throws UserRegisteredException {
        if (!checkRegisteredUser(userInfo)) {
            throw new UserRegisteredException("user.id is not null");
        }
        UserPO userPO = transformUser(userInfo);

        userPO.setPassword(MD5.create().digestHex(userPO.getPassword()));

        userDao.insert(userPO);
    }

    /**
     * 判断user是否为空，创建用户不允许用户自定义id
     * 真实环境下可能还验证用户电话，邮箱唯一性等。demo暂不处理
     *
     * @param userInfo 用户信息
     * @return
     */
    private boolean checkRegisteredUser(UserInfo userInfo) {
        return userInfo.getId() == null;
    }


    private UserInfo transformUser(UserPO userPO) {
        UserInfo userInfo = new UserInfo();
        BeanUtil.copyProperties(userPO, userInfo);
        return userInfo;
    }

    private UserPO transformUser(UserInfo userInfo) {
        UserPO userPO = new UserPO();
        BeanUtil.copyProperties(userInfo, userPO);
        return userPO;
    }
}
