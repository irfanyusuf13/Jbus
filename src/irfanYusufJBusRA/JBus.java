package irfanYusufJBusRA;
import java.sql.Timestamp;
import java.util.*;

public class JBus {
    public static void main(String[] args) {
        // PT Modul 5
        // Tes Pagination
        Bus b = createBus();
        List<Timestamp> listOfSchedules = new ArrayList<>();
        listOfSchedules.add(Timestamp.valueOf("2023-7-18 15:00:00"));
        listOfSchedules.add(Timestamp.valueOf("2023-7-20 12:00:00"));
        listOfSchedules.add(Timestamp.valueOf("2023-7-22 10:00:00"));
        listOfSchedules.add(Timestamp.valueOf("2023-7-26 12:00:00"));

        listOfSchedules.forEach(b::addSchedule);
        System.out.println("Page 1");
        Algorithm.paginate(b.schedules, 0, 3, t -> true).forEach(System.out::println);
        System.out.println("=====================================================");
        System.out.println("Page 2");
        Algorithm.paginate(b.schedules, 1, 3, t -> true).forEach(System.out::println);
        System.out.println("=====================================================");

        // Tes Booking
        String msgSuccess = "Booking Success!";
        String msgFailed = "Booking Failed";
        // valid date, invalid seat = Booking Failed
        Timestamp t1 = Timestamp.valueOf("2023-7-19 15:00:00");
        System.out.println("\nMake booking at July 19, 2023 15:00:00 Seats: RA17 RA18");
        System.out.println(Payment.makeBooking(t1, List.of("RA17", "RA18"), b)? msgSuccess : msgFailed);
        // valid date, invalid seat = Booking Failed
        Timestamp t2 = Timestamp.valueOf("2023-7-18 15:00:00");
        System.out.println("Make booking at July 18, 2023 15:00:00 Seat RA26");
        System.out.println(Payment.makeBooking(t2, "RA26", b)? msgSuccess : msgFailed);
        // valid date, valid seat = Booking Success
        System.out.println("Make booking at July 18, 2023 15:00:00 Seats: RA07 RA08");
        System.out.println(Payment.makeBooking(t2, List.of("RA07", "RA08"), b)? msgSuccess : msgFailed);
        // valid date, valid seat = Booking Success
        Timestamp t3 = Timestamp.valueOf("2023-7-20 12:00:00");
        System.out.println("Make booking at July 20, 2023 12:00:00 Seats: RA01 RA02");
        System.out.println(Payment.makeBooking(t3, List.of("RA01", "RA02"), b)? msgSuccess : msgFailed);
        // valid date, book the same seat = Booking Failed
        System.out.println("Make booking at July 20, 2023 12:00:00 Seat RA01");
        System.out.println(Payment.makeBooking(t3, "RA01", b)? msgSuccess : msgFailed);
        // check if the data changed
        System.out.println("\nUpdated Schedule");
        Algorithm.paginate(b.schedules, 0, 4, t-> true).forEach(System.out::println);
    }

    public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus(1, "Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station(1, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station(2, "Halte UI", City.JAKARTA, "Universitas Indonesia"));
        return bus;
    }
}


    
/*
public static int getBusId(){
    return 0;
}
    
public static String getBusName(){
    return "Bus";
}
    
public static boolean isDiscount(){
    return true;   
}
    
public static float getDiscountPercentage(int beforeDiscount,int afterDiscount ){
       float discountPercentage=0.0f;
       discountPercentage = (beforeDiscount - afterDiscount) * 100.0f / beforeDiscount;
    
        if (beforeDiscount < afterDiscount){
       return 0.0f;
    }
    
    return discountPercentage;
       
}

public static int getDiscountedPrice(int price, float discountPercentage){
    if (discountPercentage > 100.0f){
        return 0;
    } 
    int discountedPrice;
    discountedPrice = (int) (price -  (price * (discountPercentage / 100.0f)));
    return discountedPrice;
}

public static int getOriginalPrice(int discountedPrice,float discountPercentage){
    float discountAll;
    int price=1000;
    discountAll = (discountPercentage / 100.0f) * price;
    int originalPrice = (int) (discountedPrice + discountAll);
    return originalPrice;
}

public static float getAdminFeePercentage(){
    return 0.05f;
}


public static int getAdminFee(int price){
    float adminFee;
    adminFee= price * 0.05f;
    return (int)adminFee;
}

public static int getTotalPrice(int price,  int numberOfSeat ){
    float totalPrice;
    float adminFee = (price * numberOfSeat) * 0.05f;
    totalPrice= (price * numberOfSeat) + adminFee;
    return (int)totalPrice;
}

public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus(1, "Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station(1, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station(2, "Halte UI", City.JAKARTA, "Universitas Indonesia"));
        return bus;
    }

}
*/

