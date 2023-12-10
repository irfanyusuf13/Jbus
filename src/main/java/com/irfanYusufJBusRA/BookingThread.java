package com.irfanYusufJBusRA;

import java.sql.Timestamp;


/**
 * This class is used to give the information of a booked Bus.
 * @author Irfan Yusuf
 */

public class BookingThread extends Thread{
    private Bus bus;
    private Timestamp timestamp ;
    public BookingThread(String name, Bus bus, Timestamp timestamp){
        super(name);
        this.bus = bus;
        this.timestamp = timestamp;
        this.start();
    }
    public void run() {


        synchronized (bus) {
            Payment.makeBooking(timestamp, "RA1" , bus);
            System.out.println("Thread  " + Thread.currentThread().getId() + " ID : " + Thread.currentThread().getName() +" Is Running");
            }
        if (Payment.makeBooking(timestamp, "RA1", bus)) {
            System.out.println(" " + Thread.currentThread().getName() + " Berhasil melakukan booking");
        }
        else {
            System.out.println(" " + Thread.currentThread().getName() + " Gagal melakukan booking");
        }
        }
    }


