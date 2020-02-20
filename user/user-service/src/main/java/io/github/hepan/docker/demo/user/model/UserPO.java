package io.github.hepan.docker.demo.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/4 14:19
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pe_user")
public class UserPO {
    @AssignID("uuid")
    private String id;
    private String realName;
    private String password;
    private String loginName;
    private String mobile;
    private String email;
}
