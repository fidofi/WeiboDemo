package com.fidofi.configuration;

import com.fidofi.interceptor.ManagerInterceptor;
import com.fidofi.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by fido on 2018/1/10.
 * 拦截器配置
 */
@Configuration
public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration=registry.addInterceptor(new UserInterceptor());
        registration.addPathPatterns("/user/*");
        registration.excludePathPatterns("/user/login","/user/doLogin","/user/register");

        InterceptorRegistration registration2=registry.addInterceptor(new ManagerInterceptor());
        registration2.addPathPatterns("/manager/*");
        registration2.excludePathPatterns("/manager/login","/manager/index");

    }
}
