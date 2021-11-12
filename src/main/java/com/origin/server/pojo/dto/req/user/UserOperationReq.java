package com.origin.server.pojo.dto.req.user;

import com.origin.server.common.config.ValidGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author qijs
 * @version 1.0
 * @description: 用户操作请求对象
 * @date 2021/11/11/0011 16:28
 */
@Data
public class UserOperationReq {

    /**
     * 用户id
     */
    @Null(groups = ValidGroup.Crud.Create.class,message = "用户id必须为空")
    @NotNull(groups = {ValidGroup.Crud.Update.class,ValidGroup.Crud.Delete.class},message = "用户id不为空")
    private Integer id;

    /**
     * 用户名称
     */
    @NotBlank(groups = {ValidGroup.Crud.Update.class,ValidGroup.Crud.Create.class},message = "名称不为空")
    private String userName;

    /**
     * 手机号
     */
    @NotNull(groups = {ValidGroup.Crud.Update.class,ValidGroup.Crud.Create.class},message = "手机号不为空")
    private Integer phone;

    /**
     * 地址
     */
    @NotBlank(groups = {ValidGroup.Crud.Update.class,ValidGroup.Crud.Create.class},message = "名称不为空")
    private String address;

    /**
     * 备注
     */
    private String remark;
}
