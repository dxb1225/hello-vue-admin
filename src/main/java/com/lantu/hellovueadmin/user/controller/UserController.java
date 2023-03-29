package com.lantu.hellovueadmin.user.controller;

import com.lantu.hellovueadmin.common.vo.Result;
import com.lantu.hellovueadmin.user.entity.User;
import com.lantu.hellovueadmin.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.oas.annotations.EnableOpenApi;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dxb
 * @since 2023-03-20
 */
@Api(tags = {"用户接口列表"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

//    @Resource
//    private RedisTemplate redisTemplate;

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody User user){
        String token = userService.login(user);
        if (token != null) {
            Map<String,Object> data = new HashMap<>();
            data.put("token", token);
            return Result.success(data);
        }
        return Result.fail(20002, "用户名或密码错误!");
    }

    @ApiOperation("用户信息")
    @GetMapping("/info")
    public Result<Map<String,Object>> getUserInfo(@ApiParam("登录参数") @RequestParam("token")String token){
        Map<String,Object> data = userService.getUserInfo(token);
        return Result.success(data);
    }

    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public Result<Object> logout(@RequestHeader("X-Token") String token){
        userService.logout(token);

        return Result.success();
    }
}
