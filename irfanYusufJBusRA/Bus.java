package irfanYusufJBusRA;

public class Bus extends Serializable{
    public String name;
    public int capacity;
    public Facility facility;
    public Price price;
    public BusType busType;
    public City city;
    public Station departure;
    public Station arrival;
    
    
 public Bus(int id, String name, Facility facility, Price price, int capacity, BusType busType, City city , Station departure , Station arrival){
     super(id);
     this.name = name;
     this.facility = facility;
     this.price = price;
     this.capacity = capacity;
     this.busType = busType;
     this.city = city;
     this.departure = departure;
 }
 public String toString(){
     return "ID : "+ super.id + " Name : " + this.name + " Facility : " + this.facility + " Price : " + this.price + " Capacity : " + this.capacity + " Bus Type" + this.busType + " City : " + this.city + " Departure :" + this.departure;
 }
}
