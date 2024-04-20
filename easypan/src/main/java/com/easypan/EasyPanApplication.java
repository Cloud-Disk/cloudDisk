package com.easypan;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.transaction.annotation.*;

@SpringBootApplication(scanBasePackages = {"com.easypan"})
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
public class EasyPanApplication {
    public static void main(String[] args){
        SpringApplication.run(EasyPanApplication.class, args);
    }

}
