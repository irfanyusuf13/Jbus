package irfanYusufJBusRA;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.List;


public class Payment extends Invoice{
    private int busId;
    public Timestamp departureDate;
    public String busSeat;
    
    
public Payment(int id , int buyerId , int renterId , int busId ,  String busSeat , Timestamp departureDate){
    super(id, buyerId , renterId);
    this.busId = busId;
    this.departureDate = departureDate;
    this.busSeat = busSeat;
}
public Payment(int id , Account buyer , Renter renter,  int busId ,  String busSeat , Timestamp departureDate ) {
    super(id , buyer , renter);
    this.busId = busId;
    this.departureDate = departureDate;
    this.busSeat = busSeat; 
}
public String getDepartureInfo(){
    return "Id :" + super.id  + " Buyer Id: " + buyerId + " Renter Id: " + renterId  + " bus Id :" +busId + " departure date : "  + " bus seat : " +busSeat ;
    
}
public int getBusId(){
    return busId;
}

public String getTime(){
    return new SimpleDateFormat("dd/MMMM/yyyy hh:mm:s").format(super.time.getTime());
}

public static Schedule availableSchedule(Timestamp departureSchedule, String seat, Bus bus){
    for (Schedule jadwal : bus.schedules) {
        if (jadwal.departureSchedule.equals(departureSchedule) && jadwal.isSeatAvailable(seat)) {
            return jadwal;
        }
    }
    return null;
}


public static boolean makeBooking(Timestamp departureSchedule, String seat, Bus bus){
        for (Schedule s : bus.schedules){
            if(s.departureSchedule.equals(departureSchedule)){
                s.bookSeat(seat);
                return true;
            }
        }
        return false;
    }

public static boolean makeBooking(Timestamp departureSchedule, List<String> seat, Bus bus){
    boolean seatBooked = true;
    for (String seats : seat) {
        boolean booked = makeBooking(departureSchedule, seats, bus);
        if (!booked) {
           seatBooked  = false;
        }
    }
    return seatBooked;
}

public static Schedule availableSchedule(Timestamp departureSchedule, List<String> seat, Bus bus){
    List<Schedule> scheduleTersedia = new ArrayList<>();
    for (String seats : seat) {
        Schedule schedule = availableSchedule(departureSchedule, seats, bus);
        if (schedule != null) {
            scheduleTersedia.add(schedule);
        }
    }
    return (Schedule) scheduleTersedia;
}
}





