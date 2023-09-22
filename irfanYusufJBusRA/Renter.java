package irfanYusufJBusRA;
public class Renter extends Serializable{
    public String address;
    public String companyName;
    public int phoneNumber;

    public Renter (int id , String companyName){
        super(id);
        this.companyName= companyName;
    }
    public Renter (int id , String companyName , String address){
        super(id);
        this.companyName = companyName;
        this.address = "";
    }
    public Renter (int id , String companyName , int phoneNumber){
        super(id);
        this.companyName = companyName;
        this.phoneNumber = 0;
    }
    public Renter (int id , String companyName , int phoneNumber , String address){
        super(id);
        this.companyName = companyName;
        this.phoneNumber = 0;
        this.address = "";
    }
}