package thymeleaf.spring4.conversion;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;

/**
 * {@link java.lang.Integer}格式转换器
 */
public class IntegerFormatter implements Formatter < Integer > {

    private MessageSource messageSource;

    public IntegerFormatter( MessageSource messageSource ) {
        super();
        this.messageSource = messageSource;
    }

    private DecimalFormat createDecimalFormat( final Locale locale ) {
        final String format = this.messageSource.getMessage( "integer.format", null, locale );
        final DecimalFormat decimalFormat = new DecimalFormat( format );
        return decimalFormat;
    }

    @Override
    public String print( Integer object, Locale locale ) {
        final DecimalFormat decimalFormat = createDecimalFormat( locale );
        return decimalFormat.format( object );
    }

    @Override
    public Integer parse( String text, Locale locale ) throws ParseException {
        final DecimalFormat decimalFormat = createDecimalFormat( locale );
        return decimalFormat.parse( text ).intValue();
    }
}
