package com.irfanYusufJBusRA.controller;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.irfanYusufJBusRA.Account;
import com.irfanYusufJBusRA.Bus;
import com.irfanYusufJBusRA.Payment;
import com.irfanYusufJBusRA.Invoice;
import com.irfanYusufJBusRA.Schedule;
import com.irfanYusufJBusRA.Algorithm;

import com.irfanYusufJBusRA.dbjson.JsonAutowired;
import com.irfanYusufJBusRA.dbjson.JsonTable;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

@RestController
@RequestMapping("/Payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class, filepath = "C:\\College\\Semester 3\\OOP\\OOP Java\\JBus\\data\\json\\payment_db.json")
    public static JsonTable<Payment> paymentTable;

    public JsonTable<Payment>getJsonTable(){
        return paymentTable;
    }


    @RequestMapping(value = "/makeBooking", method = RequestMethod.POST)
    public BaseResponse<Payment>makeBooking(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int busId,
            @RequestParam List <String> busSeats,
            @RequestParam String departureDate
    ) {
        for(Account account : AccountController.accountTable){
            if(account.id == buyerId && account.balance >= BusController.busTable.get(busId).price.price && Algorithm.<Schedule>find(BusController.busTable.get(busId).schedules, s -> s.departureSchedule.equals(departureDate)) != null){
                account.balance -= BusController.busTable.get(busId).price.price;
                return new BaseResponse<>(true, "Booking Berhasil dilakukan", null);

            }
            else
                return new BaseResponse<>(false, "Booking gagal dilakukan", null);
        }

        return new BaseResponse<>(false, "Booking gagal dilakukan", null);
    }

    @RequestMapping(value = "{id}/accept", method = RequestMethod.POST)
    public BaseResponse<Payment>accept(
            @PathVariable int id

    ){
        return null;
    }
    @RequestMapping(value = "{id}/cancel", method = RequestMethod.POST)
    public BaseResponse<Payment>cancel(
            @PathVariable int id
    )
    {
        return new BaseResponse<>(true, "Cancel Pembayaran", null);
        
    }



}
