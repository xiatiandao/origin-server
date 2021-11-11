package com.origin.server.service.info.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.origin.server.mapper.info.UserMapper;
import com.origin.server.pojo.dto.req.user.UserOperationReq;
import com.origin.server.pojo.entity.info.User;
import com.origin.server.service.info.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author qijs
 * @since 2021-11-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList(UserOperationReq userOperationReq) {
        return new LambdaQueryChainWrapper<>(userMapper)
                .eq(User::getUserName,userOperationReq.getUserName())
                .eq(User::getId,userOperationReq.getId()).list();
    }

    @Override
    public void addUserInfo(UserOperationReq userOperationReq) {
        User user = new User();
        BeanUtils.copyProperties(userOperationReq,user);
        userMapper.insert(user);
    }

    @Override
    public void editUserInfo(UserOperationReq userOperationReq) {
        User user = new User();
        BeanUtils.copyProperties(userOperationReq,user);
        userMapper.updateById(user);
    }
}
