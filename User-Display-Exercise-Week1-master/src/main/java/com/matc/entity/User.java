package com.matc.entity;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */

import java.time.*;
import org.apache.log4j.*;

public class User {
    private String firstName;
    private String lastName;
    private String userid;
    private String dateOfBirth;

    private final Logger logger = Logger.getLogger(this.getClass());



    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userid    the userid
     */
    public User(String firstName, String lastName, String userid, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userid = userid;
        this.dateOfBirth = dateOfBirth;
    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets userid.
     *
     * @param  the userid
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userid='" + userid + '\'' +
                ", dateOfBirth='" + dateOfBirth +'\'' +
                ", age=" + calculateAge() + '\'' +
                '}';
    }

    public int calculateAge(){
        int age = 0;
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.parse(dateOfBirth);
        Period p = Period.between(birthday, today);

        age = p.getYears();

        return age;
    }


}
