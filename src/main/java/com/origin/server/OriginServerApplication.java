package com.origin.server;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author a1772
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.origin.server.mapper.**")
public class OriginServerApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(OriginServerApplication.class, args);
        ConfigurableEnvironment environment = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = environment.getProperty("server.port");
        String path = environment.getProperty("server.servlet.context-path");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application Origin-Server is running! Access URLs:\n\t" +
                "Local: \t\thttp://" + ip + ":" + port +  "\n\t" +
                "----------------------------------------------------------");
    }

}
