package irfanYusufJBusRA;

public class JBus
{
    public static void main (String[] args){
        int getBusId = 0;
        String getBusName = "Bus";
        boolean isDiscount = true;
        int beforeDiscount= 1000;
        int afterDiscount= 900;
        int price = 5000;
        float discountPercentage=100.0f;
        int discountedPrice= 900;
        int numberOfSeat=2;
        
        
        
        system.out.println("" + getBusId);
        system.out.println("" + getBusName);
        system.out.println("" + isDiscount);
        system.out.println("" + getDiscountPercentage);
        system.out.println("" + getDiscountedPercentage);
        system.out.println("" + getOriginalPrice);
        system.out.println("" + getAdminFeePercentage);
        
        
        
        
        
    }
    

int getBusId(){
    return 0;
}
    
String getBusName(){
    return "Bus";
}
    
boolean isDiscount(){
    return true;   
}
    
float getDiscountPercentage(int beforeDiscount,int afterDiscount ){
       if (beforeDiscount< afterDiscount);
       return 0.0f;
       
}

int getDiscountedPercentage(int price, float discountPercentage){
    if (discountPercentage>100.0f);
    return 0;
}

    
int getOriginalPrice(int discountedPrice,float discountPercentage){
    
}

float getAdminFeePercentage(){
    return 0.05f;
}

int getAdminFee(int price){
    int harga;
    harga= price * 0.5;
}

int getTotalPrice(int price,  int numberOfSeat ){
    if(price =5000 && numberofseat=2)
        return 5250;
}

    

