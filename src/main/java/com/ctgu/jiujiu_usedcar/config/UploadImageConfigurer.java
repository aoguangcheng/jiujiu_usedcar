package com.ctgu.jiujiu_usedcar.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 资源映射路径
 */
@Configuration
public class UploadImageConfigurer implements WebMvcConfigurer {

    /**上传地址*/
    @Value("${file.upload.path}")
    private String filePath;
    /**显示相对地址*/
    @Value("${file.upload.path.relative}")
    private String fileRelativePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(fileRelativePath).
                addResourceLocations("file:/" + filePath);
        registry.addResourceHandler("/images/**").
                addResourceLocations("file:/images/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}

/*registry.addResourceHandler("/images/**").
                addResourceLocations("file:/images");
* /images/**------>>相当于>>file:/C://images
* /images/xxx.jps------>>相当于>>file:/C://images/xxx.jpg
*
* */