package com.easypan.spring;

import org.slf4j.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.stereotype.*;

@Component("applicationContextProvider")
public class ApplicationContextProvider implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationContextProvider.class);
    /**
     * 上下文对象实例
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 获取applicationContext
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过name获取 Bean.
     *
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        try {
            return getApplicationContext().getBean(name);
        } catch (NoSuchBeanDefinitionException e) {
            logger.error("获取bean异常", e);
            return null;
        }

    }

    /**
     * 通过class获取Bean.
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}