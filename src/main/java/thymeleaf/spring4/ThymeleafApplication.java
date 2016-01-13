package thymeleaf.spring4;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import thymeleaf.spring4.config.ConversionConfig;
import thymeleaf.spring4.config.ErrorConfig;

/**
 * Main Class
 */
@SpringBootApplication
public class ThymeleafApplication {

    public static void main( String[] args ) {
        new SpringApplicationBuilder().sources( ThymeleafApplication.class, ConversionConfig.class, ErrorConfig.class )
                .run( args );
    }

}
