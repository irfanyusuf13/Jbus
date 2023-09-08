package irfanYusufJBusRA;

public class JBus
{
    public static void main (String[] args){
        int getBusId = 0;
        String getBusName = "Bus";
        boolean isDiscount = true;
        int beforeDiscount= 1000;
        int afterDiscount= 900;
        int price = 1000;
        float discountPercentage=100.0f;
        int discountedPrice= 900;
        int numberOfSeat=2;
            
        
        
        System.out.println("Bus ID: " + getBusId);
        System.out.println("Bus Name: " + getBusName);
        System.out.println("" + isDiscount);
        System.out.println("Harga: " + price);
        System.out.println("Diskon: " + getDiscountPercentage (beforeDiscount,afterDiscount));
        System.out.println("harga sesudah didiskon: " + getDiscountedPercentage (price,discountPercentage));
        System.out.println("harga asli: " + getOriginalPrice(1000, 10.0f));
        System.out.println("admin fee: " + getAdminFeePercentage () );
        System.out.println("harga biaya admin: " + getAdminFee (price));
        System.out.println("Total Harga: " + getTotalPrice (price,numberOfSeat) );
        
        
        
        
        
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
       discountPercentage = (afterDiscount / beforeDiscount) * 1;
    
        if (beforeDiscount < afterDiscount){
       return 0.0f;
    }
    
    return discountPercentage;
       
}

public static int getDiscountedPercentage(int price, float discountPercentage){
    if (discountPercentage > 100.0f){
        return 0;
    } 
    int discountedPrice;
    discountedPrice = price - (int) (price * (discountPercentage / 100));
    return price;
}

    
public static int getOriginalPrice(int discountedPrice,float discountPercentage){
    float originalPrice= 0.0f;
    originalPrice = discountedPrice * (100/ (100 - discountPercentage));
    return (int)originalPrice;
}

public static float getAdminFeePercentage(){
    return 0.05f;
}


public static int getAdminFee(int price){
    float adminFee= 0.0f;
    adminFee= price * 0.05f;
    return (int)adminFee;
}

public static int getTotalPrice(int price,  int numberOfSeat ){
    float totalPrice = 0.0f;
    totalPrice= (price * numberOfSeat) + price * 0.05f;
    return (int)totalPrice;
}
}

    
