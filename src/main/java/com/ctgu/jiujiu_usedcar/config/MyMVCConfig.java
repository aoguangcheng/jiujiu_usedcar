//package com.ctgu.jiujiu_usedcar.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class MyMVCConfig implements WebMvcConfigurer{
//
//    @Bean //将组件注册在容器
//    public  WebMvcConfigurer webMvcConfigurer(){
//        WebMvcConfigurer webMvcConfigurer  = new WebMvcConfigurer() {
////            @Override
////            //视图映射
////            public void addViewControllers(ViewControllerRegistry registry) {
////                registry.addViewController("/").setViewName("login");
////                registry.addViewController("/index.html").setViewName("login");
////                registry.addViewController("/main.html").setViewName("dashboard");
////            }
//
//            //注册拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/login.html", "/", "index.html", "/index", "/login", "/tologin")
//                         .excludePathPatterns("/layui/**");
//            }
//        };
//        return webMvcConfigurer;
//    }
//
//}
