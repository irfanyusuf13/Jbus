package com.irfanYusufJBusRA;

import com.irfanYusufJBusRA.dbjson.Serializable;


/**
 * This class is used to store the information of a user account.
 * @author Irfan Yusuf
 */


public class Review extends Serializable
{
    public String date;
    public String desc;


    /**
     * Constructor For Class review
     */
public Review (int id , String date , String desc){
    super();
    this.date = date;
    this.desc = desc;
}

public String toString(){
    return "ID : "+ super.id + " Date : " +this.date + " Desc : " + this.desc;
}
}
