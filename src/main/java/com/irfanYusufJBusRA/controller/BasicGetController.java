package com.irfanYusufJBusRA.controller;

import com.irfanYusufJBusRA.Algorithm;
import com.irfanYusufJBusRA.dbjson.JsonTable;
import com.irfanYusufJBusRA.dbjson.Serializable;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**.
 * This interface is used to represent a basic get controller.
 * @author Irfan Yusuf
 * @param <T> The type of the object that will be handled by the controller
 *           (e.g. Account, Bus, Payment, etc)
 */

public interface BasicGetController <T extends Serializable>{


    JsonTable<T> getJsonTable();

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public default List<T> getPage(
            @RequestParam(value = "page", defaultValue = "8") int page,
            @RequestParam(value = "size", defaultValue = "5") int pagesize
    ){
        return Algorithm.<T>paginate(getJsonTable(),page,pagesize,a ->true);
    }
    @GetMapping("/{id}")
    public default T getById(@PathVariable int id){
        return Algorithm.<T>find(getJsonTable(), e -> e.id == id);
    }
}