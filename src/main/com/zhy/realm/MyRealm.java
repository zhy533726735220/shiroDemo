package com.zhy.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class MyRealm implements Realm {
    @Override
    public String getName() {
        // 名字随便给一个，只要能唯一标记即可
        return "MyRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        // 本次将在之前程序的基础上继续使用UsernamePasswordToken完成信息的的传递
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        // 在shiro里面是利用字符数组实现了密码的传递，所以不能将其直接变为String
        String password = new String((char[]) token.getCredentials());
        // 此时直接使用一个固定的用户名和密码进行验证处理操作
        // "admin",是读的数据库
        if (!"admin".equals(username)) {
            throw new UnknownAccountException("用户名不存在！");
        }
        //"hello"，是读的数据库
        if (!"hello".equals(password)) {
            throw new IncorrectCredentialsException("密码输入错误！");
        }
        return new SimpleAuthenticationInfo(username, password, this.getName());
    }
}
