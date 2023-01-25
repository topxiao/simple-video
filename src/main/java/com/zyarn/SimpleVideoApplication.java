package com.zyarn;

import cn.dev33.satoken.quick.SaQuickManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({com.zyarn.utils.SpringInit.class})
@SpringBootApplication
public class SimpleVideoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleVideoApplication.class, args);


        System.out.println("\n------ 启动成功 ------");
        System.out.println("name: " + SaQuickManager.getConfig().getName());
        System.out.println("pwd:  " + SaQuickManager.getConfig().getPwd());
    }

}
