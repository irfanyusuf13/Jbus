package irfanYusufJBusRA;

public class JBus
{
    public static void main (String[] args){
        
       /* Bus testBus = createBus();
        System.out.println(testBus.name);
        System.out.println(testBus.facility);
        System.out.println(testBus.price.price);
        System.out.println(testBus.capacity);*/
    
    }
    

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

public static Bus createBus(){
    Price price = new Price (75000, 5);
    Bus bus = new Bus (5000,"Netlab Bus", Facility.LUNCH, price,25);
    return bus;
}
}

    

