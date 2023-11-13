package com.irfanYusufJBusRA;

import com.irfanYusufJBusRA.dbjson.Serializable;

import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;

public class Bus extends Serializable {
    public String name;
    public int capacity;
    public List <Facility> facilities;
    public Price price;
    public BusType busType;

    public Station departure;
    public Station arrival;
    public List<Schedule> schedules;
    public int accountId;


public Bus(int id, String name, Facility facility, Price price, int capacity, BusType busType, City city , Station departure , Station arrival){
    super();
    this.name = name;
    this.facilities = facilities;
    this.price = price;
    this.capacity = capacity;
    this.busType = busType;
    this.departure = departure;
    this.arrival = arrival;
    this.schedules = new ArrayList  <Schedule>();

}

    public Bus(String name, List<Facility> facilities, Price priceObj, int capacity, BusType busType, Station departure, Station arrival) {
    }

    public String toString(){
    return "ID : "+ super.id + " Name : " + this.name + " Facility : " + this.facilities + " Price : " + this.price + " Capacity : " + this.capacity + " Bus Type" + this.busType  + " Departure :" + this.departure + " Arrival : " +this.arrival;
}


public Object write(){
    return null;
}
public boolean read(String content){
    return false;
}

    public void addSchedule(Timestamp schedule) {
        try {
            for (Schedule existingSchedule : schedules) {
                if (existingSchedule.departureSchedule.equals(schedule)) {
                    throw new IllegalArgumentException("Jadwal Telah Terisi");
                }
            }
            schedules.add(new Schedule(schedule, this.capacity));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " );
        }
    }

}