package com.irfanYusufJBusRA.controller;

import com.irfanYusufJBusRA.*;
import com.irfanYusufJBusRA.dbjson.JsonAutowired;
import com.irfanYusufJBusRA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;


@RestController
@RequestMapping("/Bus")
public class    BusController implements BasicGetController<Bus>{

    @JsonAutowired(value = Bus.class, filepath = "C:\\College\\Semester 3\\OOP\\OOP Java\\JBus\\data\\json\\Bus_db.json")
    public static JsonTable<Bus> busTable;

    public JsonTable<Bus>getJsonTable(){
        return busTable;
    }
@PostMapping ("/addSchedule")
public BaseResponse<Bus>addSchedule(
        @RequestParam int busId,
        @RequestParam String time
        ) {
    try {
        Bus bus = Algorithm.<Bus>find(busTable, bis -> bis.id ==busId);
        bus.addSchedule(Timestamp.valueOf(time));
        return new BaseResponse<>(true, "Jadwal Baru berhasil ditambah", bus);
    }
    catch (Exception e){
        return new BaseResponse<>(false, "Jadwal Baru tidak dapat ditambah", null);
    }
}
    @PostMapping ("/create")
    public BaseResponse<Bus> create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int capacity,
            @RequestParam List <Facility> facilities,
            @RequestParam BusType busType,
            @RequestParam int price,
            @RequestParam int stationDepartureId,
            @RequestParam int stationArrivalId
            )
{
    if(Algorithm.<Bus>exists(busTable, bis -> bis.arrival.id == stationArrivalId) && Algorithm.<Bus>exists(busTable, bis -> bis.departure.id == stationDepartureId)) {
        Account account = Algorithm.<Account>find(AccountController.accountTable, bis -> bis.id == accountId);
        if (account != null) {
            if (account.company != null) {
                Bus bus = Algorithm.<Bus>find(busTable, bis -> bis.arrival.id == stationArrivalId && bis.departure.id == stationDepartureId);
                Price priceNew = new Price(price);
                Bus bisCreate= new Bus (name, facilities, priceNew, capacity, busType, bus.departure, bus.arrival);
                return new BaseResponse<>(true, "Bus berhasil Dibuat", bisCreate);
            }
            else
                return new BaseResponse<>(false, "Akun gagal dibuat ", null);
        }
        return new BaseResponse<>(false, "Akun dengan id yang dicari gagal ditemukan", null);
    } return new BaseResponse<>(false, "ID departure atau arrival tidak ada di database", null);

}
@GetMapping("/getMyBus")
    public List<Bus> getMyBus(
            @RequestParam int accountId) {
        return Algorithm.<Bus>collect(getJsonTable(),
                b->b.accountId==accountId);}
}






