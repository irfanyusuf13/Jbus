package irfanYusufJBusRA;

public class Voucher extends Serializable implements FileParser{
    public String name;
    private boolean used;
    public double minimum;
    public double cut;
    public int code;
    public Type type;


public Voucher (int id, String name, int code , Type type , double minimum , double cut){
    super(id);
    this.name = name;
    this.code = code;
    this.type = type;
    this.minimum = minimum;
    this.cut = cut;
    this.used = false;   
}
public boolean isUsed(){
    return this.used;
}

public boolean canApply(Price price){
    if ((price.price > this.minimum && this.used == false)){
        return true;
    }
    else{
        return false;
    }
}

public double apply (Price price){
    double applyPrice;
    this.used = true;
    
    if(this.type == Type.DISCOUNT){
        if (this.cut >= 100){
           this.cut = 100;
           return 0;
        } 
        else{
        applyPrice = (price.price * (1 -(this.cut / 100)));
        return applyPrice;
    }
    }
    else {
       if (price.price < this.cut){
           return 0;
       }
       else{
       applyPrice = price.price - cut; 
       return applyPrice;
    }
    }
    }

 public Object write(){
     return null;
 }

 public boolean read(String content){
     return false;
 }
}