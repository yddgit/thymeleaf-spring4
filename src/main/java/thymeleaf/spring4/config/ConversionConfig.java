package thymeleaf.spring4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import thymeleaf.spring4.conversion.DateFormatter;
import thymeleaf.spring4.conversion.IntegerFormatter;
import thymeleaf.spring4.conversion.StringToShowModeConverter;

/**
 * Spring Conversion Service Configuration
 */
@Configuration
public class ConversionConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private MessageSource messageSource;

    @Override
    public void addFormatters( FormatterRegistry formatterRegistry ) {
        formatterRegistry.addFormatter( new DateFormatter( messageSource ) );
        formatterRegistry.addFormatter( new IntegerFormatter( messageSource ) );
        formatterRegistry.addConverter( new StringToShowModeConverter() );
    }
}
