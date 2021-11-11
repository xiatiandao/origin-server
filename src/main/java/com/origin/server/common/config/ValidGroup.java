package com.origin.server.common.config;

import javax.validation.groups.Default;

/**
 * @author qijs
 * @version 1.0
 * @description: 分组校验
 * @date 2021/11/11/0011 16:13
 */
public interface ValidGroup extends Default {
    interface Crud extends ValidGroup{
        interface Create extends Crud{}

        interface Update extends Crud{}

        interface Query extends Crud{}

        interface Delete extends Crud{}
    }
}
