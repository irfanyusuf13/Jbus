package irfanYusufJBusRA;

public class Bus extends Serializable{
    public String name;
    public int capacity;
    public Facility facility;
    public Price price;
    
 public Bus(int id, String name, Facility facility, Price price, int capacity){
     super(id);
     this.name = name;
     this.facility = facility;
     this.price = price;
     this.capacity = capacity;
 }
}
