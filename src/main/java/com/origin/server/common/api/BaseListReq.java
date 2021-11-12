package com.origin.server.common.api;

import lombok.Data;

/**
 * @author qijs
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月24日 11:11:00
 */
@Data
public class BaseListReq {
    /**当前页*/
    private Integer pageNum = 1;

    /**每页长度*/
    private Integer pageSize = 10;
}
