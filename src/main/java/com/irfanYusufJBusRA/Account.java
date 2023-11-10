package com.irfanYusufJBusRA;

import com.irfanYusufJBusRA.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Serializable {
    public String email;
    public String name;
    public String password;
    public double balance = 0;
    public Renter company;
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z_]+?\\.[a-zA-Z.]+[a-zA-Z]+$";
    public static final String REGEX_PASSWORD = "^( =.*[a-z])( =.*[A-Z])( =.*\\d)[a-zA-Z\\d]{8,}$";

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

    public boolean topUp(double amount) {
        if (amount <= 0) {
            return false;
        }
        this.balance += amount;
        return true;
    }
}



    
