package com.irfanYusufJBusRA;

import java.sql.Timestamp;
import java.util.Calendar;

public class Invoice extends Serializable
{
 public int buyerId;
 public int renterId;
 public BusRating rating;
 public Timestamp time;
 public PaymentStatus status;
public enum BusRating{
     NONE,
     NEUTRAL,
     GOOD,
     BAD;
 }
public enum PaymentStatus{
     FAILED,
     WAITING,
     SUCCESS;
} 
 
 protected Invoice (int id, int buyerId , int renterId){
     super();
     this.buyerId = buyerId;
     this.renterId = renterId;
     this.time = new Timestamp(System.currentTimeMillis());
     this.rating = BusRating.NONE;
     this.status = PaymentStatus.WAITING;
 }
 public Invoice (int id , Account buyer , Renter renter){
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
