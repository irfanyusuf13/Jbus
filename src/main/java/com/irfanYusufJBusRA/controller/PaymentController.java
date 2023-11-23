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
        for(Account acc : AccountController.accountTable){
            if(acc.id == buyerId && acc.balance >= BusController.busTable.get(busId).price.price && Algorithm.<Schedule>find(BusController.busTable.get(busId).schedules, s -> s.departureSchedule.equals(departureDate)) != null){
                acc.balance -= BusController.busTable.get(busId).price.price;
                Payment payment = new Payment(buyerId, renterId, busId, busSeats, Timestamp.valueOf(departureDate));
                payment.status = Invoice.PaymentStatus.WAITING;

                paymentTable.add(payment);

                return new BaseResponse<>(true, "Berhasil melakukan booking", payment);

            } else
                return new BaseResponse<>(false, "Gagal melakukan booking", null);
        }
        return new BaseResponse<>(false, "Gagal melakukan booking", null);
    }

    @RequestMapping(value = "{id}/accept", method = RequestMethod.POST)
    public BaseResponse<Payment>accept(
            @PathVariable int id

    ){
        if(!(Algorithm.<Payment>exists(paymentTable, e -> e.id == id))){
            return new BaseResponse<>(false, "Tidak ada payment", null);
        }

        Payment newPayment = Algorithm.<Payment>find(paymentTable, e -> e.id == id);
        newPayment.status = Invoice.PaymentStatus.SUCCESS;
        return new BaseResponse<>(true, "Payment berhasil", newPayment);
    }
    @RequestMapping(value = "{id}/cancel", method = RequestMethod.POST)
    public BaseResponse<Payment>cancel(
            @PathVariable int id
    )
    {
        if(!(Algorithm.<Payment>exists(paymentTable, e -> e.id == id))){
            return new BaseResponse<>(false, "Tidak ada payment", null);
        }

        Payment newPayment = Algorithm.<Payment>find(paymentTable, e -> e.id == id);
        newPayment.status = Invoice.PaymentStatus.FAILED;
        return new BaseResponse<>(true, "Membatalkan payment", newPayment);
    }

    }




