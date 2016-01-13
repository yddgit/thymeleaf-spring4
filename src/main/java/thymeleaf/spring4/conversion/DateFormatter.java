package thymeleaf.spring4.conversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;

/**
 * {@link java.util.Date}格式转换器
 */
public class DateFormatter implements Formatter < Date > {

    private MessageSource messageSource;

    public DateFormatter( MessageSource messageSource ) {
        super();
        this.messageSource = messageSource;
    }

    public Date parse( final String text, final Locale locale ) throws ParseException {
        final SimpleDateFormat dateFormat = createDateFormat( locale );
        return dateFormat.parse( text );
    }

    public String print( final Date object, final Locale locale ) {
        final SimpleDateFormat dateFormat = createDateFormat( locale );
        return dateFormat.format( object );
    }

    private SimpleDateFormat createDateFormat( final Locale locale ) {
        final String format = this.messageSource.getMessage( "date.format", null, locale );
        final SimpleDateFormat dateFormat = new SimpleDateFormat( format );
        dateFormat.setLenient( false );
        return dateFormat;
    }

}
