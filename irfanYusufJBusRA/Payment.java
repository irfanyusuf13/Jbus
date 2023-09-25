package irfanYusufJBusRA;
public class Payment extends Invoice{
    private int busId;
    public String departureDate;
    public String busSeat;
    
public Payment(int id , int buyerId , int renterId , String time , int busId , String departureDate , String busSeat){
    super(id, buyerId , renterId , time);
    this.busId = busId;
    this.departureDate = departureDate;
    this.busSeat = busSeat;
}
public Payment(int id , Account buyer , Renter renter, String time , int busId , String departureDate , String busSeat) {
    super(id , buyer , renter , time);
    this.busId = busId;
    this.departureDate = departureDate;
    this.busSeat = busSeat;
}
public String toString(){
    return "Id :" + super.id  + " Buyer Id: " + buyerId + " Renter Id: " + renterId  + " time: " + time +  " bus Id :" +busId + " departure date : " + departureDate + " bus seat : " +busSeat;
}
public int getBusId(){
    return busId;
}
}
