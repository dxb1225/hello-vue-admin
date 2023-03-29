package com.lantu.hellovueadmin.user.service;

import com.lantu.hellovueadmin.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dxb
 * @since 2023-03-20
 */
public interface UserService extends IService<User> {

    String login(User user);

    Map<String, Object> getUserInfo(String token);

    void logout(String token);
}
