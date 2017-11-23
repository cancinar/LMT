package com.iccinar.lmt;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author iccinar
 * @date 23.10.2017.
 */

@Configuration
@Controller
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {


        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/resources/**").addResourceLocations("classpath:templates/resources/");
        }

}
