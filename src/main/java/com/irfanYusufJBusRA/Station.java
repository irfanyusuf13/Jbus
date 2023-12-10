package com.irfanYusufJBusRA;

import com.irfanYusufJBusRA.dbjson.Serializable;


/**
 * This class is used to store the information of a Station
 * @author Irfan Yusuf
 */

public class Station extends Serializable {
    public City city;
    public String stationName;
    public String address;



    /**
     * Constructor objects for station class
     */
public Station(String stationName , City city ,  String address){
    super();
    this.stationName = stationName;
    this.city = city;
    this.address = address;
}
public String toString(){
    return "Id : "+  super.id + " Station Name : " + this.stationName + " City : " + this.city + " Address : " +this.address;
}

}
