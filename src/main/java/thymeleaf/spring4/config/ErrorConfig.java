package thymeleaf.spring4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import thymeleaf.spring4.controller.AppErrorController;

/**
 * Error Handle Configuration
 */
@Configuration
public class ErrorConfig {

    @Autowired
    private ErrorAttributes errorAttributes;

    @Bean
    public AppErrorController appErrorController() {
        return new AppErrorController( errorAttributes );
    }
}
