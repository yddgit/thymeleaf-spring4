package thymeleaf.spring4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thymeleaf.spring4.entities.User;
import thymeleaf.spring4.entities.repositories.UserRepository;

/**
 * User Service
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {
        super();
    }

    /**
     * Find all users
     * 
     * @return User list
     */
    public List < User > findAll() {
        return this.userRepository.findAll();
    }

    /**
     * Add user to repository
     * 
     * @param user User
     */
    public void add( final User user ) {
        this.userRepository.add( user );
    }

    /**
     * Remove user from repository
     * 
     * @param id User id
     */
    public void remove( final Integer id ) {
        this.userRepository.remove( id );
    }

    /**
     * Find user by id
     * 
     * @param id User id
     * @return User
     */
    public User findById( Integer id ) {
        return this.userRepository.findById( id );
    }
}
