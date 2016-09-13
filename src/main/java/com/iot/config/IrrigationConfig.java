package com.iot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.iot.services.DeviceService;
import com.iot.services.MotorServiceImpl;

@Configuration
public class IrrigationConfig {

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                	.allowedOrigins("https://smiley-plant.run.aws-usw02-pr.ice.predix.io")
                	.allowedMethods("POST", "GET")
                	.allowCredentials(false).maxAge(3600)
                	.allowedHeaders("*");
            }
        };
    }
	
	@Bean
	public DeviceService getIrrigationService(){
		return new MotorServiceImpl();
	}
}
