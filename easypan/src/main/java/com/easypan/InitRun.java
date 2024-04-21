package com.easypan;

import com.easypan.component.*;
import com.easypan.exception.*;
import org.slf4j.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

import javax.annotation.*;
import javax.sql.*;

@Component("initRun")
public class InitRun implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitRun.class);

    @Resource
    private DataSource dataSource;
    InitRun
    @Resource
    private RedisComponent redisComponent;

    @Override
    public void run(ApplicationArguments args) {
        try {
            dataSource.getConnection();
            redisComponent.getSysSettingsDto();
            logger.error("服务启动成功，可以开始愉快的开发了");
        } catch (Exception e) {
            logger.error("数据库或者redis设置失败，请检查配置");
            throw new BusinessException("服务启动失败");
        }
    }
}
