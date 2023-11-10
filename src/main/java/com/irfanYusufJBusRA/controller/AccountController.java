package  com.irfanYusufJBusRA.controller;

import com.irfanYusufJBusRA.Account;
import com.irfanYusufJBusRA.Predicate;
import com.irfanYusufJBusRA.Renter;
import com.irfanYusufJBusRA.Algorithm;
import com.irfanYusufJBusRA.dbjson.JsonAutowired;
import com.irfanYusufJBusRA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    @JsonAutowired(value = Account.class, filepath = "C:\\College\\Semester 3\\OOP\\OOP Java\\JBus\\data\\json\\acount_db.json")
    public static JsonTable<Account>accountTable;
    public JsonTable<Account> getJsonTable(){
        return accountTable;
    }
    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")
    BaseResponse<Account> register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password)
    {
        Predicate<Account> s = (valid) -> valid.email.equals(email);

        String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}$";
        String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z_]+?\\.[a-zA-Z.]+[a-zA-Z]+$";
        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherPassword = patternPassword.matcher(password);
        Matcher matcherEmail = patternEmail.matcher(email);

        if (name.isBlank() == false && matcherPassword.find() && matcherEmail.find() && Algorithm.exists(accountTable,s) == false) {
            String passwordToHash = password;
            String generatedPassword = null;

            try
            {
                MessageDigest md = MessageDigest.getInstance("MD5");

                md.update(passwordToHash.getBytes());

                byte[] bytes = md.digest();

                StringBuilder sb = new StringBuilder();
                for (int i = 0;i < bytes.length;i++) {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                generatedPassword = sb.toString();
            }
            catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            Account tempAcc =  new Account(name, email, generatedPassword);
            accountTable.addElement(tempAcc);
            return new BaseResponse<>(true, "Berhasil register", tempAcc);
        }
        return new BaseResponse<>(false, "Gagal register", null);

    }

    @PostMapping("/login")
    BaseResponse<Account>login
            (@RequestParam String email,
             @RequestParam String password){

        String passwordToHash = password;
        String generatedPassword = null;

      try{
          MessageDigest md = MessageDigest.getInstance("MD5");
          md.update(passwordToHash.getBytes());
          byte[] bytes = md.digest();
          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < bytes.length;i++) {
              sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
          }
          generatedPassword = sb.toString();

      }
      catch (NoSuchAlgorithmException e ){
          e.printStackTrace();
      }

        for (Account i : accountTable) {
            if (i.password.equals(generatedPassword) && i.email.equals(email))
                return new BaseResponse<>(true, "login berhasil dilakukan", i);
        }
        return new BaseResponse<>(false, "login gagal dilakukan", null);
    }

    @PostMapping ("/{id}/registerRenter")
    BaseResponse<Renter> registerRenter
            (@PathVariable int id,
             @RequestParam String companyName,
             @RequestParam String address,
             @RequestParam String phoneNumber)
    {
        for (Account top : accountTable) {
            if (top.id == id && top.company == null){
                top.company = new Renter(companyName, phoneNumber, address);
                return new BaseResponse<>(true, "register renter berhasil dilakukan", top.company);
            }
        }
        return new BaseResponse<>(false, "register renter gagal dilakukan", null);
    }

    @PostMapping("/{id}/topUp")
    BaseResponse<Double> topUp(@PathVariable int id, @RequestParam double amount)
    {
        for (Account top : accountTable) {
            if (top.id == id){
                if (top.topUp(amount)){
                    return new BaseResponse<>(true, "Top Up Berhasil Dilakukan", amount);
                }
            }
        }
        return new BaseResponse<>(false, "Top Up Gagal Dilakukan ", null);
    }
    }



    /*@GetMapping("/{id}")
    String getById(@PathVariable int id) { return "account id " + id + " not found!"; }
     */

