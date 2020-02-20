package io.github.hepan.docker.demo.user.edge.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/15 23:24
 **/
@Data
@Builder
@AllArgsConstructor
public class Response implements Serializable {

    public static final  Response SUCCESS=new Response();

    /**发送短信技能冷却中**/
    public static final Response PHONE_CODE_MESSAGE_CD=new Response("10001","this phone code message is cool down");

    private String code;
    private String message;

    public Response (){
        code="0";
        message="success";
    }

    public static Response exception(Exception e){
        return new Response("9999",e.getMessage());

    }

}
