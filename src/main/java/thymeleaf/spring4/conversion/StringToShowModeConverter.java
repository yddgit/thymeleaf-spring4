package thymeleaf.spring4.conversion;

import org.springframework.core.convert.converter.Converter;

import thymeleaf.spring4.entities.ShowMode;

/**
 * {@link java.lang.String}到{@link thymeleaf.spring4.entities.ShowMode}的转换器
 */
public class StringToShowModeConverter implements Converter < String, ShowMode > {

    @Override
    public ShowMode convert( String source ) {
        String value = source.trim();
        if ( "".equals( value ) ) {
            return null;
        }
        return ShowMode.forName( value );

    }
}
