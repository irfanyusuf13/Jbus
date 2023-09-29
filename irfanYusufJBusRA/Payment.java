package irfanYusufJBusRA;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Payment extends Invoice{
    private int busId;
    public Calendar departureDate;
    public String busSeat;
    
    
public Payment(int id , int buyerId , int renterId , int busId ,   String busSeat){
    super(id, buyerId , renterId);
    this.busId = busId;
    departureDate.add(Calendar.DATE, 2);
    this.busSeat = busSeat;
}
public Payment(int id , Account buyer , Renter renter,  int busId ,  String busSeat) {
    super(id , buyer , renter);
    this.busId = busId;
    departureDate.add(Calendar.DATE, 2);
    this.busSeat = busSeat; 
}
public String getDepartureInfo(){
    return "Id :" + super.id  + " Buyer Id: " + buyerId + " Renter Id: " + renterId  + " bus Id :" +busId + " departure date : "  + " bus seat : " +busSeat ;
    
}
public int getBusId(){
    return busId;
}

public String getTime(){
    return new SimpleDateFormat("dd/MMMM/yyyy hh:mm:s").format(this.departureDate.getTime());
}
}
