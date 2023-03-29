package com.lantu.hellovueadmin.user.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lantu.hellovueadmin.user.entity.User;
import com.lantu.hellovueadmin.user.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lantu.hellovueadmin.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dxb
 * @since 2023-03-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String login(User user) {
        //验证用户名和密码
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername());
        queryWrapper.eq(User::getPassword, user.getPassword());
        User loginUser = this.getOne(queryWrapper);

        if (loginUser != null) {
            //验证成功产生token
            String token = "user:"+ UUID.randomUUID();
            loginUser.setPassword(null);
            redisTemplate.opsForValue().set(token, loginUser);
            return token;
        }

        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        Object obj = redisTemplate.opsForValue().get(token);

        User loginUser = JSON.parseObject(JSON.toJSONString(obj), User.class);

        Map<String,Object> data = new HashMap<>();

        data.put("roles", Arrays.asList(loginUser.getRoles()));
        data.put("name",loginUser.getUsername());
        data.put("avatar",loginUser.getAvatar());

        return data;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }


}
