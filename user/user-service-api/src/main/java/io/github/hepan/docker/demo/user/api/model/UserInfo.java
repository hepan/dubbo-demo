package io.github.hepan.docker.demo.user.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/4 11:34
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {
    private String id;
    private String realName;
    private String password;
    private String loginName;
    private String phone;
    private String email;
}
