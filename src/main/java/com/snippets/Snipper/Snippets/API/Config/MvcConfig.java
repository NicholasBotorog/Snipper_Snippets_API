package com.snippets.Snipper.Snippets.API.Config;

import com.snippets.Snipper.Snippets.API.Interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(final InterceptorRegistry registry){
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/register", "/login");
    }
}
