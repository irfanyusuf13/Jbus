package com.irfanYusufJBusRA;

import java.util.ArrayList;


/**
 * This class is used to store the information of a Validate
 * @author Irfan Yusuf
 */
public class Validate
{

    /**
     * Constructor objects for Validate class
     */
    public Validate(){
        
    }

    public static ArrayList <Double> filter (Price [] list , int value , boolean less){
        ArrayList<Double> arr = new ArrayList<Double>();
    for (int i = 0; i < list.length; i++) {
            Price harga = list[i];
            if (less == true && harga.price <= value) {
                arr.add(harga.price);
            }
            else if(less == false && harga.price > value) {
                arr.add(harga.price);
            }
        }
        return arr;
    }
}
