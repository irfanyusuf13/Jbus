package com.irfanYusufJBusRA;
import java.sql.Timestamp;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JBus {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(JBus.class, args);
    }
        /*String filepath = "C:\\College\\Semester 3\\OOP\\OOP Java\\JBus\\data\\station.json";
        Gson gson = new Gson();

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(filepath));
            List<Station> stationjson = gson.fromJson(buffer, new TypeToken<List<Station>>() {}.getType());
            stationjson.forEach(e -> System.out.println(e.toString()));
            System.out.println();
            buffer.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
         */
        /*
        try {
            String filepath = "C:\\College\\Semester 3\\OOP\\OOP Java\\JBus\\data\\accountDatabase.json";
            Gson gson = new Gson();
            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
            Account account1 = new Account("Irfan", "Irfan@gmail.com", "ngikngok");
            tableAccount.add(account1);
            tableAccount.writeJson();

            for (Account akun : tableAccount) {
                System.out.println(akun.toString());
            }

            JsonTable<Bus> busList = new JsonTable<>(Bus.class,filepath);
            List<Bus> filteredBus = filterByDeparture(busList,City.JAKARTA,0,3);
            filteredBus.forEach(bus -> System.out.println(bus.toString()));
        }
        catch (Throwable t){
            t.printStackTrace();
        }
        Bus bus = createBus();
        bus.schedules.forEach(Schedule::printSchedule);
        for(int i =0; i < 10; i++){
            BookingThread thread = new BookingThread("Thread " + i,bus, Timestamp.valueOf("2023-07-27 19:00:00"));
        }
        Thread.sleep(1000);
        bus.schedules.forEach(Schedule::printSchedule);
    }


    public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus(1, "Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station(1, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station(2, "Halte UI", City.JAKARTA, "Universitas Indonesia"));
        Timestamp timestamp = Timestamp.valueOf("2023-07-27 19:00:00");
        bus.addSchedule(timestamp);
        return bus;
    }
    public static List<Bus> filterByDeparture(List<Bus> buses, City departure, int page, int pageSize) {
        Predicate<Bus> filterPredicate = bus -> bus.city == departure;
        List<Bus> filteredBus = Algorithm.collect(buses, filterPredicate);
        List<Bus> paginateBus = Algorithm.paginate(filteredBus, page, pageSize, bus -> true);

        return paginateBus;
    }


    public static List<Bus> filterByPrice (List<Bus> buses, int min, int max){
        List<Bus> filteredPrice = new ArrayList<>();
        for (Bus bus : buses) {
            double busesPrice = bus.price.price;
            if (busesPrice >= min && busesPrice <= max) {
                filteredPrice.add(bus);
            }
        }
        return filteredPrice;
    }

    public static List<Bus> filterBusId (List<Bus> buses, int id){
        List<Bus> filteredId = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.id == id) {
                return filteredId;
            }
        }
        return null;
    }
    public static List<Bus> filterByDepartureAndArrival(List<Bus> buses, City departure,City arrival, int page, int pageSize){
        Predicate<Bus> filterPredicate = bus -> bus.city == departure && bus.city == arrival;
        List<Bus> filteredDepartureArrival = Algorithm.collect(buses, filterPredicate);
        List<Bus> paginatedDepartureAndArrival = Algorithm.paginate(filteredDepartureArrival, page, pageSize, bus -> true);

        return paginatedDepartureAndArrival;
    }


         */
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

