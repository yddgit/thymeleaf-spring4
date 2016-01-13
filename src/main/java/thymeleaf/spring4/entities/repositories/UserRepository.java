package thymeleaf.spring4.entities.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import thymeleaf.spring4.entities.ShowMode;
import thymeleaf.spring4.entities.User;

/**
 * User Repository
 */
@Repository
public class UserRepository {

    private final List < User >         users;

    private final Map < Integer, User > usersMap;

    public UserRepository() {
        super();

        this.users = new ArrayList < User >();
        this.usersMap = new HashMap < Integer, User >();

        final User u1 = new User();
        u1.setId( 1 );
        u1.setFirstName( "Tom" );
        u1.setLastName( "Cruise" );
        u1.setNationality( "US" );
        u1.setAge( 25 );
        u1.setGender( "M" );
        u1.setShowMode( new ShowMode[] { ShowMode.LOG, ShowMode.CONSOLE } );
        u1.setAdmin( true );
        u1.setBirth( new Date() );
        u1.setComment( "Handsome" );
        u1.setPassword( "123456" );
        this.users.add( u1 );
        this.usersMap.put( u1.getId(), u1 );

        final User u2 = new User();
        u2.setId( 2 );
        u2.setFirstName( "Tom" );
        u2.setLastName( "Hanks" );
        u2.setNationality( "EN" );
        u2.setAge( 24 );
        u2.setGender( "M" );
        u2.setShowMode( new ShowMode[] { ShowMode.CONSOLE } );
        u2.setAdmin( false );
        u2.setBirth( new Date() );
        u2.setComment( "Ture Man" );
        u2.setPassword( "123456" );
        this.users.add( u2 );
        this.usersMap.put( u2.getId(), u2 );

        final User u3 = new User();
        u3.setId( 3 );
        u3.setFirstName( "Dwayne" );
        u3.setLastName( "Johnson" );
        u3.setNationality( "JP" );
        u3.setAge( 23 );
        u3.setGender( "M" );
        u3.setShowMode( new ShowMode[] { ShowMode.OFF, ShowMode.CONSOLE } );
        u3.setAdmin( true );
        u3.setBirth( new Date() );
        u3.setComment( "The Rock" );
        u3.setPassword( "123456" );
        this.users.add( u3 );
        this.usersMap.put( u3.getId(), u3 );

        final User u4 = new User();
        u4.setId( 4 );
        u4.setFirstName( "Jason" );
        u4.setLastName( "Statham" );
        u4.setNationality( "JP" );
        u4.setAge( 26 );
        u4.setGender( "F" );
        u4.setShowMode( new ShowMode[] { ShowMode.LOG, ShowMode.OFF } );
        u4.setAdmin( true );
        u4.setBirth( new Date() );
        u4.setComment( "Actor" );
        u4.setPassword( "123456" );
        this.users.add( u4 );
        this.usersMap.put( u4.getId(), u4 );

        final User u5 = new User();
        u5.setId( 5 );
        u5.setFirstName( "John" );
        u5.setLastName( "Apricot" );
        u5.setNationality( "Antarctica" );
        u5.setAge( 35 );
        u5.setGender( "M" );
        u5.setShowMode( new ShowMode[] { ShowMode.LOG, ShowMode.OFF } );
        u5.setAdmin( false );
        u5.setBirth( new Date() );
        u5.setComment( "Unknown" );
        u5.setPassword( "123456" );
        this.users.add( u5 );
        this.usersMap.put( u5.getId(), u5 );
    }

    /**
     * Find all users
     * 
     * @return User list
     */
    public List < User > findAll() {
        return new ArrayList < User >( this.users );
    }

    /**
     * Add user to repository
     * 
     * @param user User
     */
    public void add( final User user ) {
        this.users.add( user );
        Integer id = Collections.max( usersMap.keySet() );
        id++;
        user.setId( id );
        this.usersMap.put( id, user );
    }

    /**
     * Remove user from repository
     * 
     * @param id User id
     */
    public void remove( final Integer id ) {
        if ( id > 5 && this.usersMap.containsKey( id ) ) {
            User u = this.usersMap.remove( id );
            this.users.remove( u );
        }
    }

    /**
     * Find user by id
     * 
     * @param id User id
     * @return User
     */
    public User findById( Integer id ) {
        return this.usersMap.get( id );
    }
}
