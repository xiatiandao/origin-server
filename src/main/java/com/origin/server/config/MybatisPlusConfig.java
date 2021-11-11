package com.origin.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 单数据源配置（jeecg.datasource.open = false时生效）
 * @author a1772
 */
@Configuration
//@MapperScan("com.origin.server.mapper.**")
public class MybatisPlusConfig {

    /**
     *  分页插件
     */
    //@Bean
    //public PaginationInterceptor paginationInterceptor() {
    //    // 设置sql的limit为无限制，默认是500
    //    return new PaginationInterceptor().setLimit(-1);
    //}
}
