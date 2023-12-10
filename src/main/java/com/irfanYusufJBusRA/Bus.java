package com.irfanYusufJBusRA;
import com.irfanYusufJBusRA.dbjson.Serializable;

import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;

/**
 * This class is used to represent a Bus
 * @author Irfan Yusuf
 */


public class Bus extends Serializable
{
    public int capacity;
    public List<Facility> facilities;
    public String name;
    public Price price;
    public BusType busType;
    public Station departure;
    public Station arrival;
    public int accountId;
    public List<Schedule> schedules;


    /**
     * Constructor of class bus
     */

    public Bus(int accountId, String name, List<Facility> facilities, Price price, int capacity, BusType busType, Station departure, Station arrival){
        super();
        this.accountId = accountId;
        this.capacity = capacity;
        this.name = name;
        this.facilities = facilities;
        this.price = price;
        this.busType = busType;
        this.departure = departure;
        this.arrival = arrival;

        this.schedules = new ArrayList <Schedule>();
    }

    public String toString(){
        return "\nBus Id: " + super.id + "\nCapacity: " + this.capacity + "\nName: " + this.name + "\nFacility: " + this.facilities + "\nPrice: " + this.price + "\nBus type: " + this.busType + "\nDeparture: " + this.departure + "\nArrival: " + this.arrival;
    }

    public Object write(){
        return null;
    }

    public boolean read(String content){
        return false;
    }


    /**
     * This method is used to add schedule for bus
     */

    public void addSchedule(Timestamp schedule) {
        try {
            for (Schedule existingSchedule : schedules) {
                if (existingSchedule.departureSchedule.equals(schedule)) {
                    throw new Exception("Terdapat jadwal dengan waktu yang sama.");
                }
            }
            schedules.add(new Schedule(schedule, this.capacity));
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menambahkan jadwal: " + e.getMessage());
        }
    }
}