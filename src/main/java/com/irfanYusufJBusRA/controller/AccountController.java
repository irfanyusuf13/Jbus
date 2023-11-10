package  com.irfanYusufJBusRA.controller;

import com.irfanYusufJBusRA.Account;
import com.irfanYusufJBusRA.Renter;
import com.irfanYusufJBusRA.dbjson.JsonAutowired;
import com.irfanYusufJBusRA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    @JsonAutowired(value = Account.class, filepath = "C:\\College\\Semester 3\\OOP\\OOP Java\\JBus\\src\\main\\java\\com\\irfanYusufJBusRA\\json")
    public static JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }
}

    /*BaseResponse<Account>Register(String name, String email, String password){

    }
    BaseResponse<Double>topUp(int, double){

    }
    BaseResponse<Account>login(String email, String password){

    }
    BaseResponse<Renter>registerRenter(int, String companyName, String phoneNumber, String address){

    }
    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        return new Account(name, email, password);
    }

    @GetMapping("/{id}")
    String getById(@PathVariable int id) { return "account id " + id + " not found!"; }
}

     */
