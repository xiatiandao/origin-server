package com.origin.server.common.api;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "当前页", example = "1", required = true)
    private Integer pageNum = 1;

    /**每页长度*/
    @ApiModelProperty(value = "每页长度", example = "10", required = true)
    private Integer pageSize = 10;
}
