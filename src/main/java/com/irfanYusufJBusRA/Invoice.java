package com.irfanYusufJBusRA;

import com.irfanYusufJBusRA.dbjson.Serializable;

import java.sql.Timestamp;

/**
 * This class is used to store the information of an invoice.
 * @author Irfan Yusuf
 */

public class Invoice extends Serializable
{
 public int buyerId;
 public int renterId;
 public BusRating rating;
 public Timestamp time;
 public PaymentStatus status;


    /**
     * Enum for Bus Rating
     * */
public enum BusRating{
     NONE,
     NEUTRAL,
     GOOD,
     BAD;
 }

    /**
     * Enum for Payment Status
     * */
public enum PaymentStatus{
     FAILED,
     WAITING,
     SUCCESS;
}

    /**
     * Invoice Constructor
     */
 protected Invoice (int buyerId , int renterId){
     super();
     this.buyerId = buyerId;
     this.renterId = renterId;
     this.time = new Timestamp(System.currentTimeMillis());
     this.rating = BusRating.NONE;
     this.status = PaymentStatus.WAITING;
 }


    /**
     * Invoice Constructor
     */
 public Invoice (Account buyer , Renter renter){
     super();
     this.buyerId = buyer.id;
     this.renterId = renter.id;
     this.time = new Timestamp(System.currentTimeMillis());
     this.rating = BusRating.NONE;
     this.status = PaymentStatus.WAITING;
 }
 public String toString (){
     return  "Invoice Id :" + super.id  + " Buyer Id: " + buyerId + " Renter Id: " + renterId  + " time: " + time  + "Rating :" + this.rating + " Status : " + this.status;
 }
 
 
}
