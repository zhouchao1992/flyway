package com.zc.log.config;

import com.zc.log.aspect.SystemLogAspect;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@AutoConfigureOrder(2147483647)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ConditionalOnClass(SystemLogAspect.class)
@ConditionalOnMissingBean(SystemLogAspect.class)
public class SystemLogAutoConfiguration {

    @Bean
    public SystemLogAspect systemLogAspect() {
        return new SystemLogAspect();
    }
}