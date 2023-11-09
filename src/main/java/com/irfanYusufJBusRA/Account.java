package com.irfanYusufJBusRA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Serializable {
    public String email;
    public String name;
    public String password;
    public static final String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+(\\.[A-Za-z]+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=\\S+$).{8,}$";

public Account(String name , String email , String password){
    super();
    this.name = name;
    this.email = email;
    this.password = password;
}

public String toString(){
    return "ID : " +  super.id + " Name : " + this.name + " Email : " + this.email + " Password : " + this.password;
}

 public Object write(){
     return null;
 }

 public boolean read(String content){
     return false;
 }
    public boolean validate() {
        Pattern patternEmail = Pattern.compile("REGEX_EMAIL");
        Pattern patternPassword = Pattern.compile("REGEX_PASSWORD");

        Matcher matcherPassword = patternPassword.matcher(password);
        Matcher matcherEmail = patternEmail.matcher((email));

        if (matcherPassword.find() && matcherEmail.find()){
            return true;
        }
        return false;

    }
}



    
