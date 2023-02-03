package com.dev.tool;

import cn.xuyanwu.spring.file.storage.EnableFileStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author puye(0303)
 */
@EnableFileStorage
@SpringBootApplication
public class DevServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevServerApplication.class, args);
    }

}
