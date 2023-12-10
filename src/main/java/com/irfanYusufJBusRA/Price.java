package com.irfanYusufJBusRA;


/**
 * This class is used to store the information of a price.
 * @author Irfan Yusuf
 */
public class Price{


    /**
     * Store the rebate information
     */
    public double rebate;


    /**
     * Store the price information
     */
    public double price;
    //public int discount;

    /**
     * Constructor for objects of class Price
     */
    
public Price(double price){
     this.price = price;
     this.rebate = 0;
}

/*public Price (double price, int discount){
    this.price = price;
    this.discount = discount;
    this.rebate = 0;
}
*/


    /**
     * Constructor for objects of class Price
     */
public Price (double price, double rebate){
    this.price = price;
    this.rebate = rebate;
}

/*private double getDiscountedPrice(){
   if (this.discount >= 100){
     return 0.0;  
   }
    else{
        return ((double) (100 - this.discount) / 100) * this.price;
    }    
  }
  
private double getRebatedPrice(){
    if(this.rebate>this.price){
    return 0;
}
    else{ 
    return this.price - this.rebate;
}
}
*/

    /**
     * This method is used to get the price of a room
     * @return String of price and rebate
     */
public String toString(){
    return "Price : "+ this.price +" Rebate : "+ this.rebate;
}
}