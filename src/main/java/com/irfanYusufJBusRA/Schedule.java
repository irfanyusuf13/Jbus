package com.irfanYusufJBusRA;
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * This class is used to store the information of a Schedule.
 * @author Irfan Yusuf
 */

public class Schedule
{
  public Map <String, Boolean > seatAvailability;
  public Timestamp departureSchedule;


    /**
     * Constructor objects for Schedule Class
     */
    public Schedule(Timestamp departureSchedule , int numberOfSeats){
      this.departureSchedule = departureSchedule;

       initializeSeatAvailability (numberOfSeats);
  }

    /**
     * This method is used initialize available of schedule seat
     */

    private void  initializeSeatAvailability (int numberOfSeats){
     this.seatAvailability = new LinkedHashMap<>();
     for(int  seatNumber = 1 ; seatNumber <= numberOfSeats; seatNumber++){
         String sn =seatNumber <10 ?"0"+seatNumber : ""+seatNumber;
         seatAvailability.put("RA" + seatNumber, true);
     }
  }

    /**
     * This method is used to print the schedule
     */
    public void printSchedule() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy HH:mm:ss");
        String formattedDepartureSchedule = dateFormat.format(this.departureSchedule.getTime());

        // Print tanggal keberangkatan
        System.out.println("Tanggal keberangkatan: " + formattedDepartureSchedule);

        // Print daftar kursi dan ketersediaan kursinya
        System.out.println("Daftar kursi dan ketersediaan kursinya: ");

        // Create a list of seats and sort them numerically
        int maxSeatsPerRow = 4; // Assuming there are 4 seats per row
        int currentSeat = 1;

        for (String seat : this.seatAvailability.keySet()) {
            String symbol = this.seatAvailability.get(seat)? "O" : "X";
            System.out.print(seat + " : " + symbol + "\t");
            if (currentSeat % maxSeatsPerRow == 0) {
                System.out.println();
            }
            currentSeat++;
        }
        System.out.println("\n");
    }


    /**
     * This method is used to check availability of bus seat
     */
     public boolean isSeatAvailable(String seat) {
        Boolean availability = seatAvailability.get(seat);
    return seatAvailability.getOrDefault(seat, false);
}

    /**
     * This method is used to check book seat
     */

    public void bookSeat (String seat){
          this.seatAvailability.put(seat,false);
    }
    public boolean isSeatAvailable(List<String> seats) {
        for (String seat : seats) {
            if (!seatAvailability.getOrDefault(seat, false)) {
                return false;
            }
        }
        return true;
    }
    public void bookSeat (List<String> seat) {
        for (String seats : seat) {
            if (seatAvailability.containsKey(seats)) {
                seatAvailability.put(seats, false);
            }
        }
    }

    public String toString(){
            long seatTerisi = seatAvailability.values().stream().filter(b -> !b).count();
            int jumlahSeat = seatAvailability.size();
            return "Schedule: " + departureSchedule +
                    "\nOccupied: " + seatTerisi
                    + "/" + jumlahSeat;
        }


}




