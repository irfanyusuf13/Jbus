package com.irfanYusufJBusRA.controller;

import com.irfanYusufJBusRA.*;
import com.irfanYusufJBusRA.dbjson.JsonAutowired;
import com.irfanYusufJBusRA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

import static com.irfanYusufJBusRA.controller.BusController.busTable;

/**.
 * This class is used to handle /Payment requests from the client.
 * @author Irfan Yusuf
 */

@RestController
@RequestMapping("/Payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class, filepath = "C:\\College\\Semester 3\\OOP\\OOP Java\\JBus\\data\\json\\payment_db.json")
    public static JsonTable<Payment> paymentTable;

    public JsonTable<Payment>getJsonTable(){
        return paymentTable;
    }

    /**
     * This method is used to handle /Payment/ makeBooking bus requests from the client.
     * This method is used to book a bus with it schedule and seat
     * @author Irfan Yusuf
     */
    @RequestMapping(value = "/makeBooking", method = RequestMethod.POST)
    public BaseResponse<Payment> makeBooking(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int busId,
            @RequestParam List <String> busSeats,
            @RequestParam String departureDate
    ) {
        if (Algorithm.<Account>exists(AccountController.accountTable, x -> x.id == buyerId && x.company.id == renterId)){
            if (Algorithm.<Bus>exists(BusController.busTable, x -> x.id == busId)){
                Account theBuyer = Algorithm.<Account>find(AccountController.accountTable, x -> x.id == buyerId && x.company.id == renterId);
                Bus theBus = busTable.get(busId-1);
                if (theBuyer.balance >= (theBus.price.price*busSeats.size())){;
                    Timestamp departure = Timestamp.valueOf(departureDate);

                    if (Algorithm.<Schedule>exists(theBus.schedules, x -> x.departureSchedule.compareTo(departure) == 0)){
                        if(Payment.makeBooking(departure, busSeats, theBus)) {
                            Payment payment = new Payment(buyerId,renterId,busId,busSeats, departure);
                            paymentTable.add(payment);
                            return new BaseResponse<>(true, "Berhasil Melakukan Booking", payment);
                        } return new BaseResponse<>(false, "Berhasil melakukan booking", null);
                    }return new BaseResponse<>(false, "Gagal Melakukan Booking ", null);
                } return new BaseResponse<>(false, "Gagal Melakukan Booking ", null);
            } return new BaseResponse<>(false, "Gagal Melakukan Booking ", null);
        } return new BaseResponse<>(false, "Gagal Melakukan Booking ", null);
    }


    /**
     * This method is used to handle /Payment/ Accept bus requests from the client.
     * This method is used to accept the booking
     * @author Irfan Yusuf
     */

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


    /**
     * This method is used to handle /Payment/ Cancel bus requests from the client.
     * This method is used to cancel the booking
     * @author Irfan Yusuf
     */
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




