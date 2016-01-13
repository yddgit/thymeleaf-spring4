package thymeleaf.spring4.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import thymeleaf.spring4.entities.ShowMode;
import thymeleaf.spring4.entities.User;
import thymeleaf.spring4.service.MyService;
import thymeleaf.spring4.service.UserService;

/**
 * Index Controller
 */
@Controller
public class IndexController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MyService     myService;

    @Autowired
    private UserService   userService;

    @ModelAttribute( "allUsers" )
    public List < User > populateUsers() {
        return this.userService.findAll();
    }

    @ModelAttribute( "genders" )
    public Map < String, String > genders() {
        Map < String, String > genders = new HashMap < String, String >();
        genders.put( "M", "Male" );
        genders.put( "F", "Female" );
        return genders;
    }

    @ModelAttribute( "showModes" )
    public ShowMode[] showModes() {
        return new ShowMode[] { ShowMode.CONSOLE, ShowMode.LOG, ShowMode.OFF };
    }

    @RequestMapping( "/index" )
    public String index( final User user,
            @RequestParam( value = "name", required = false, defaultValue = "World" ) String name, Model model,
            ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response ) {
        model.addAttribute( "name", name );
        model.addAttribute( "date", new Date() );
        model.addAttribute( "num", 123456789 );
        model.addAttribute( "bool", true );
        model.addAttribute( "showMode", ShowMode.CONSOLE );
        model.addAttribute( "user", this.userService.findById( 5 ) );
        return "index";
    }

    @RequestMapping( "/dynamic" )
    public String toDynamic( final User user, Model model, HttpServletRequest request ) {
        return "dynamic";
    }

    @RequestMapping( value = "/dynamic", params = { "addUser" } )
    public String addUser( final User user, final BindingResult bindingResult, final ModelMap model,
            HttpServletRequest request ) {
        if ( bindingResult.hasErrors() ) {
            return "dynamic";
        }
        this.userService.add( user );
        model.clear();
        return "redirect:/dynamic";
    }

    @RequestMapping( value = "/dynamic", params = { "removeUser" } )
    public String removeUser( final User user, @RequestParam( value = "removeUser", required = true ) final Integer id,
            final BindingResult bindingResult, HttpServletRequest request ) {
        this.userService.remove( id );
        return "redirect:/dynamic";
    }

    @RequestMapping( "/fragment1" )
    public String fragment1() {
        return "index :: fragment1";
    }

    @RequestMapping( "/fragment2" )
    public String fragment2() {
        return "index :: #fragment2";
    }

    @RequestMapping( "/fragment3" )
    public String fragment3() {
        return "index :: fragment3 (var1 = 'Hello', var2 = 'Thymeleaf')";
    }
}
