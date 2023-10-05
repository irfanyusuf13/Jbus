package irfanYusufJBusRA;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Timestamp;

public class Bus extends Serializable implements FileParser{
    public String name;
    public int capacity;
    public Facility facility;
    public Price price;
    public BusType busType;
    public City city;
    public Station departure;
    public Station arrival;
    public List<Schedule> schedules;
    
    
public Bus(int id, String name, Facility facility, Price price, int capacity, BusType busType, City city , Station departure , Station arrival){
    super(id);
    this.name = name;
    this.facility = facility;
    this.price = price;
    this.capacity = capacity;
    this.busType = busType;
    this.city = city;
    this.departure = departure;
    this.arrival = arrival;
    this.schedules = new ArrayList  <Schedule>();
    
}
public String toString(){
    return "ID : "+ super.id + " Name : " + this.name + " Facility : " + this.facility + " Price : " + this.price + " Capacity : " + this.capacity + " Bus Type" + this.busType + " City : " + this.city + " Departure :" + this.departure;
}


public Object write(){
    return null;
}
public boolean read(String content){
    return false;
}

public void addSchedule(Timestamp schedule) { 
    schedules.add(new Schedule(schedule, this.capacity));
    }

}