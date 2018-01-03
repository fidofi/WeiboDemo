package com.fidofi.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by fido on 2018/1/3.
 * 关于在springboot项目中jsp展示绝对路径地址的图片的配置
 *
 */
@Configuration
public class MyWebAppConfiguration extends WebMvcConfigurerAdapter {

    /**
     * 对文件的路径进行配置, 创建一个虚拟路径/Path/** ，即只要在<img src="/Path/picName.jpg" />便可以直接引用图片
     *这是图片的物理路径  "file:/+本地图片的地址"
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/photo/**").addResourceLocations("file:/D:/课设图片库/");
        super.addResourceHandlers(registry);
    }
}
