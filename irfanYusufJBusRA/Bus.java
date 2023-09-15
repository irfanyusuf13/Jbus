package irfanYusufJBusRA;

public class Bus
{
    public String name;
    public int capacity;
    public Facility facility;
    public Price price;
    
 public Bus(String name, Facility facility, Price price, int capacity){
     this.name = name;
     this.facility = facility;
     this.price = price;
     this.capacity = capacity;
 }
}
