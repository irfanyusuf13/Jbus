package irfanYusufJBusRA;
import java.sql.Timestamp;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class JBus {
    public static void main(String[] args) {
        String filepath = "C:\\College\\Semester 3\\OOP\\OOP Java\\JBus\\data\\station.json";
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

