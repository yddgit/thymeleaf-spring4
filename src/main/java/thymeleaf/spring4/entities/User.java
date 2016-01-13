package thymeleaf.spring4.entities;

import java.util.Date;

/**
 * User
 */
public class User {

    private Integer    id          = null;
    private String     firstName   = null;
    private String     lastName    = null;
    private String     nationality = null;
    private Integer    age         = null;
    private String     gender      = null;
    private ShowMode[] showMode    = null;
    private Boolean    admin       = null;
    private Date       birth       = null;
    private String     comment     = null;
    private String     password    = null;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality( String nationality ) {
        this.nationality = nationality;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge( Integer age ) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender( String gender ) {
        this.gender = gender;
    }

    public ShowMode[] getShowMode() {
        return showMode;
    }

    public void setShowMode( ShowMode[] showMode ) {
        this.showMode = showMode;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin( Boolean admin ) {
        this.admin = admin;
    }

    public String getComment() {
        return comment;
    }

    public void setComment( String comment ) {
        this.comment = comment;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth( Date birth ) {
        this.birth = birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String createCompleteName() {
        return getName();
    }

    public String createCompleteNameWithSeparator( String separator ) {
        return this.firstName + separator + this.lastName;
    }

}
