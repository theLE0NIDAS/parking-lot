package entities;

import java.util.Map;

import enums.VehicleType;

public class ParkingSpotMap {
    private Map<VehicleType, Integer> spotsPerVehicleType;

    public ParkingSpotMap(Map<VehicleType, Integer> spotsPerVehicleType){
        this.spotsPerVehicleType = spotsPerVehicleType;
    }

    public Map<VehicleType, Integer> getSpotsPerVehicleType(){
        return spotsPerVehicleType;
    }
}
