package com.origin.server.pojo.entity.info;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author qijs
 * @since 2021-11-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String userName;

    /**
     * 手机号
     */
    private Integer phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 备注
     */
    private String remark;

    private Date updateTime;

    private Date createTime;


}
