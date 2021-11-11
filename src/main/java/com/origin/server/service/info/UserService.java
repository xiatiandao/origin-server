package com.origin.server.service.info;


import com.baomidou.mybatisplus.extension.service.IService;
import com.origin.server.pojo.dto.req.user.UserOperationReq;
import com.origin.server.pojo.entity.info.User;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author qijs
 * @since 2021-11-11
 */
public interface UserService extends IService<User> {

    List<User> queryUserList(UserOperationReq userOperationReq);

    void addUserInfo(UserOperationReq userOperationReq);

    void editUserInfo(UserOperationReq userOperationReq);
}
