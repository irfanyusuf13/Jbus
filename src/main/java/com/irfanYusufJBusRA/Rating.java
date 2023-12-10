package com.irfanYusufJBusRA;


/**
 * CLass for Rating
 * This class is used to represent the rating of a Bus
 * @author Irfan Yusuf
 */

public class Rating{
    private long count;
    private long total;


    /**
     * Constructor for objects of class Rating
     */
public Rating(){
        this.count = 0;
        this.total = 0;
   }


    /**
     * This method is used to add a rating
     */
   
public void insert (int rating){
    this.total += rating;
    this.count++;
}


    /**
     * This method is used to get the average rating
     */
public double getAverage(){
    if(this.count == 0){
        return 0;    
    }
    return this.total / this.count;
}


    /**
     * This method is used to get the rating count
     */
public long getCount (){
    return this.count;
}

    /**
     * This method is used to get the total rating
     */
public long getTotal(){
    return this.total;
}
public String toString(){
    return "Count : "+ this.count + " Total : " + this.total;
}


}
