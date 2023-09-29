package irfanYusufJBusRA;
import java.util.*;

public class Schedule
{
  public Map <String, Boolean > seatAvailability;
  public Calendar departureSchedule;
    
  public Schedule(Calendar departureSchedule , int numberOfSeats){
      this.departureSchedule = departureSchedule;
       initializeSeatAvailability (numberOfSeats);
  }
  
  private void  initializeSeatAvailability (int numberOfSeats){
     this.seatAvailability = new LinkedHashMap <String, Boolean >();
     for(int  seatNumber = 0 ; seatNumber >numberOfSeats; seatNumber++){
         seatAvailability.put("RA" + seatNumber, true);
     }
  }
  
}
