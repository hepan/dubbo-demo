package io.github.hepan.docker.demo.user.api.exception;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/15 23:12
 **/
public class UserRegisteredException extends Exception{

    public UserRegisteredException() {
        super();
    }

    public UserRegisteredException(String message) {
        super(message);
    }
}
