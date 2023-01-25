package com.zyarn.utils;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.env.Environment;

public class SpringInit implements ApplicationContextAware {
    private static ApplicationContext context = null;

    public SpringInit() {
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (context == null) {
            context = applicationContext;
        }

    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static Environment getEnvironment() {
        return context.getEnvironment();
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static <T> T getBean(String beanName, Class<T> clazz) {
        return context.getBean(beanName, clazz);
    }

    public static <T> T getBean(Class<T> clazz) throws BeansException {
        return context.getBean(clazz);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) throws BeansException {
        return context.getBeansOfType(clazz);
    }

    public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) throws BeansException {
        return context.getBeansWithAnnotation(annotationType);
    }

    public static void publishEvent(ApplicationEvent event) {
        if (context != null) {
            context.publishEvent(event);
        }

    }
}
