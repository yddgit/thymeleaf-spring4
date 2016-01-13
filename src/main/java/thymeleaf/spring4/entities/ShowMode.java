package thymeleaf.spring4.entities;

/**
 * ShowMode Enumeration
 */
public enum ShowMode {

    OFF( "OFF" ), CONSOLE( "CONSOLE" ), LOG( "LOG" );

    private final String name;

    private ShowMode( final String name ) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return getName();
    }

    /**
     * 将指定字符串转为ShowMode类型
     * 
     * @param name 要转换的字符串
     * @return 对应的ShowMode类型
     */
    public static ShowMode forName( final String name ) {
        if ( name == null ) {
            throw new IllegalArgumentException( "Name cannot be null for feature" );
        }
        if ( name.toUpperCase().equals( "OFF" ) ) {
            return OFF;
        } else if ( name.toUpperCase().equals( "CONSOLE" ) ) {
            return CONSOLE;
        } else if ( name.toUpperCase().equals( "LOG" ) ) {
            return LOG;
        }
        throw new IllegalArgumentException( "Name \"" + name + "\" does not correspond to any Feature" );
    }

}
