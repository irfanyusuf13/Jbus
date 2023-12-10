package com.irfanYusufJBusRA;

import com.irfanYusufJBusRA.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * This class is used to store the information of a user account.
 * @author Irfan Yusuf
 */

public class Account extends Serializable {

    /**
     * The email of the account.
     */
    public String email;

    /**
     * The name of the account.
     */
    public String name;

    /**
     * The password of the account.
     */
    public String password;

    /**
     * The balance of the account.
     */
    public double balance = 0;

    /**
     * The company of the account.
     */
    public Renter company;

    /**
     * The Regex for email of the account.
     * example :irfan@ui.ac.id
     * character cant contain space or special characters
     */
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z_]+?\\.[a-zA-Z.]+[a-zA-Z]+$";

    /**
     * The Regex for Password of the account.
     * password at least has 9 character maximum
     * contain minimum 1 uppercase letter, 1 lowercase dan 1 number
     */
    public static final String REGEX_PASSWORD = "^( =.*[a-z])( =.*[A-Z])( =.*\\d)[a-zA-Z\\d]{8,}$";


    /**
     * This is the constructor for the Account class.
     * @author Irfan Yusuf
     */
    public Account(String name, String email, String password) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String toString() {
        return "ID : " + super.id + " Name : " + this.name + " Email : " + this.email + " Password : " + this.password;
    }

    public Object write() {
        return null;
    }

    public boolean read(String content) {
        return false;
    }


    /**
     * This method is used to validate the email and password of the account.
     * @author Irfan Yusuf
     * @return Returns true if the email and password are valid.
     */

    public boolean validate() {
        Pattern patternEmail = Pattern.compile("REGEX_EMAIL");
        Pattern patternPassword = Pattern.compile("REGEX_PASSWORD");

        Matcher matcherPassword = patternPassword.matcher(password);
        Matcher matcherEmail = patternEmail.matcher((email));

        if (matcherPassword.find() && matcherEmail.find()) {
            return true;
        }
        return false;

    }


    /**
     * This method is used to  top up money for the account .
     * @author Irfan Yusuf
     * @return Returns true if the amount is positive number.
     */
    public boolean topUp(double amount) {
        if (amount <= 0) {
            return false;
        }
        this.balance += amount;
        return true;
    }
}



    
