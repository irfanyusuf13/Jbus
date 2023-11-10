package com.irfanYusufJBusRA;
import com.irfanYusufJBusRA.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Renter extends Serializable {
    public String address;
    public String companyName;
    public String phoneNumber;
    private final String REGEX_NAME  = "^[A-Z][A-Za-z0-9_]{3,19}$";
    private final String REGEX_PHONE = "\\d{9,12}";


    public Renter (String companyName){
        super();
        this.companyName= companyName;
        this.address = "";
        this.phoneNumber = "0";
    }
    public Renter (String companyName , String phoneNumber){
        super();
        this.companyName = companyName;
        this.address = "";
        this.phoneNumber = phoneNumber;
    }
    public Renter (String companyName , String phoneNumber , String address){
        super();
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public boolean validate(){
        Pattern patternHp = Pattern.compile("REGEX_PHONE");
        Pattern patternNama = Pattern.compile("REGEX_NAME");

        Matcher matcherCompany = patternNama.matcher(companyName);
        Matcher matcherHp = patternHp.matcher((phoneNumber));

    if (matcherCompany.find() && matcherHp.find()){
        return true;
    }
    return false;

    }
}
