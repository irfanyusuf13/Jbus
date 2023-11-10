package com.irfanYusufJBusRA;

import com.irfanYusufJBusRA.dbjson.Serializable;

public class Station extends Serializable {
    public City city;
    public String stationName;
    public String address;
    
public Station(int id, String stationName , City city ,  String address){
    super();
    this.stationName = stationName;
    this.city = city;
    this.address = address;
}
public String toString(){
    return "Id : "+  super.id + " Station Name : " + this.stationName + " City : " + this.city + " Address : " +this.address;
}

}
