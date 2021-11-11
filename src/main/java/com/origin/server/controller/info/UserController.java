package com.origin.server.controller.info;


import com.origin.server.common.config.ValidGroup;
import com.origin.server.pojo.dto.ResultBean;
import com.origin.server.pojo.dto.req.user.UserOperationReq;
import com.origin.server.pojo.entity.info.User;
import com.origin.server.service.info.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表 前端控制器
 * @author qijs
 * @since 2021-11-11
 */
@RestController
@RequestMapping("/info/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/queryUserList")
    public ResultBean<List<User>> queryUserList(@RequestBody UserOperationReq userOperationReq){
        return ResultBean.success(userService.queryUserList(userOperationReq));
    }

    @PostMapping("/addUserInfo")
    public ResultBean addUserInfo(@Validated(value = ValidGroup.Crud.Create.class) @RequestBody UserOperationReq userOperationReq){
        userService.addUserInfo(userOperationReq);
        return ResultBean.ok();
    }

    @PostMapping("/editUserInfo")
    public ResultBean editUserInfo(@Validated(value = ValidGroup.Crud.Update.class) @RequestBody UserOperationReq userOperationReq){
        userService.editUserInfo(userOperationReq);
        return ResultBean.ok();
    }
}
