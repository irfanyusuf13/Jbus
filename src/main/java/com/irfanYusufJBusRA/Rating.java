package com.irfanYusufJBusRA;


public class Rating{
    private long count;
    private long total;
    
public Rating(){
        this.count = 0;
        this.total = 0;
   }
   
public void insert (int rating){
    this.total += rating;
    this.count++;
}
public double getAverage(){
    if(this.count == 0){
        return 0;    
    }
    return this.total / this.count;
}
public long getCount (){
    return this.count;
}
public long getTotal(){
    return this.total;
}
public String toString(){
    return "Count : "+ this.count + " Total : " + this.total;
}


}
