package com.irfanYusufJBusRA.controller;

import com.irfanYusufJBusRA.City;
import com.irfanYusufJBusRA.Station;
import com.irfanYusufJBusRA.dbjson.JsonAutowired;
import com.irfanYusufJBusRA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**.
 * This class is used to handle /Station requests from the client.
 * @author Irfan Yusuf
 */
@RestController
@RequestMapping("/station")
public class StationController implements BasicGetController<Station> {
    public static @JsonAutowired(value = Station.class, filepath = "C:\\College\\Semester 3\\OOP\\OOP Java\\JBus\\data\\json\\station.json") JsonTable<Station> stationTable;
    @Override
    public JsonTable<Station> getJsonTable() {
        return stationTable;
    }

    //Add new Station

    /**
     * This method is used to handle /station/ createStation bus requests from the client.
     * This method is used to create the station
     * @author Irfan Yusuf
     */
    @PostMapping("/create")
    public BaseResponse<Station> createStation(
            @RequestParam String stationName,
            @RequestParam String city,
            @RequestParam String address
    ) {
        try {
            // Validate parameters
            if (stationName.isBlank() || city.isBlank() || address.isBlank()) {
                return new BaseResponse<>(false, "Parameter values cannot be blank or null", null);
            }

            // Validate city as a valid enum value
            City cityEnum = City.valueOf(city.toUpperCase());

            // Create a new station using the provided details
            Station newStation = new Station(stationName, cityEnum, address);

            // Add the new station to the stationTable
            stationTable.add(newStation);

            //Success response message
            return new BaseResponse<>(true, "Station added successfully", newStation);
        } catch (IllegalArgumentException e) {
            // Handle invalid enum value
            return new BaseResponse<>(false, "Invalid city value", null);
        } catch (Exception e) {
            // Handle other unexpected errors
            return new BaseResponse<>(false, "An error occurred while adding the station", null);
        }
    }

    /**
     * This method is used to handle /station/ getAllStation bus requests from the client.
     * This method is used to get all the station we made
     * @author Irfan Yusuf
     */
    @GetMapping("/getAll")
    public List<Station> getAllStation() { return getJsonTable();}

}
