package entities;

import java.util.List;
import enums.VehicleType;

public class ParkingFloor {

    private int floorNumber;
    private List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpots){
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
    }

    public ParkingSpot getAvailableSpot(VehicleType vehicleType){
        for(ParkingSpot spot : parkingSpots){
            if(spot.getSpotType() == vehicleType && spot.tryOccupy()){
                return spot;
            }
        }

        return null;
    }

    public int getFloorNumber(){
        return floorNumber;
    }
}