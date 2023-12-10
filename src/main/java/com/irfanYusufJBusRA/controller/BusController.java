package com.irfanYusufJBusRA.controller;

import com.irfanYusufJBusRA.*;
import com.irfanYusufJBusRA.dbjson.JsonAutowired;
import com.irfanYusufJBusRA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**.
 * This class is used to handle /Bus  requests from the client.
 * @author Irfan Yusuf
 */


@RestController
@RequestMapping("/bus")
public class    BusController implements BasicGetController<Bus>{

    @JsonAutowired(value = Bus.class, filepath = "C:\\College\\Semester 3\\OOP\\OOP Java\\JBus\\data\\json\\Bus_db.json")
    public static JsonTable<Bus> busTable;

    public JsonTable<Bus>getJsonTable(){
        return busTable;
    }


    /**
     * This method is used to handle /Bus/ create bus requests from the client.
     * This method is used to create a bus from renter account
     * @author Irfan Yusuf
     */
    @PostMapping("/create")
    public BaseResponse<Bus> create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int capacity,
            @RequestParam List<Facility> facilities,
            @RequestParam BusType busType,
            @RequestParam int price,
            @RequestParam int stationDepartureId,
            @RequestParam int stationArrivalId
    ){
        try{
            Account account = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == accountId);
            if (account == null || account.company == null) {
                return new BaseResponse<>(false, "Akun tidak ada", null);
            }
            Station stationDep = Algorithm.<Station>find(StationController.stationTable, stat -> stat.id == stationDepartureId);
            Station stationArr = Algorithm.<Station>find(StationController.stationTable, stat -> stat.id == stationArrivalId);
            if(stationDep == null || stationArr == null){
                return new BaseResponse<>(false, "Kota keberangkatan/kedatangan tidak ada ", null);
            }

            Bus newbus = new Bus(
                    accountId,
                    name,
                    facilities,
                    new Price(price),
                    capacity,
                    busType,
                    stationDep,
                    stationArr
            );
            busTable.add(newbus);
            busTable.writeJson();
            return new BaseResponse<>(true, "Bus baru telah didaftarkan", newbus);}
        catch (IllegalArgumentException | IOException e){
            return new BaseResponse<>(false, "Bus gagal dibuat",null);
        }
    }

    /**
     * This method is used to handle /Bus/ add schedule bus requests from the client.
     * This method is used to add a schedule for the bus
     * @author Irfan Yusuf
     */
    @PostMapping("/addSchedule")
    public BaseResponse<Bus> addSchedule(
            @RequestParam int busId,
            @RequestParam String time
    ) {
        try {
            Bus newBus = Algorithm.<Bus>find(busTable, t -> t.id == busId);
            newBus.addSchedule(Timestamp.valueOf(time));
            return new BaseResponse<>(true, "Jadwal berhasil ditambahkan", newBus);

        } catch (Exception e) {
            return new BaseResponse<>(false, "Jadwal tidak berhasil ditambahkan", null);
        }
    }


    @GetMapping("/getMyBus")
    public List<Bus> getMyBus(@RequestParam int accountId) {
        return Algorithm.<Bus>collect(getJsonTable(), b->b.accountId==accountId);
    }

    /**
     * This method is used to handle /Bus/ getAllBus requests from the client.
     * This method is used to get all the bus we made in create method
     * @author Irfan Yusuf
     */
    @GetMapping("/getAllBus")
    public List<Bus> getAllBus() { return getJsonTable();}


}




