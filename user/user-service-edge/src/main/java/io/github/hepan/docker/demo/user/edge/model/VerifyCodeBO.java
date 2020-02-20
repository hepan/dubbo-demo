package io.github.hepan.docker.demo.user.edge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/19 11:20
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VerifyCodeBO implements Serializable {
    private Integer code;
    private Date startTime;
}
