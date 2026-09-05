package services;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entities.ParkingFloor;
import entities.ParkingSpot;
import entities.ParkingSpotMap;
import entities.Ticket;
import enums.PricingType;
import enums.VehicleType;
import entities.Vehicle;

public class ParkingLot {

    private static ParkingLot instance;

    private int numFloors;
    private ParkingSpotMap spotMap;
    private List<ParkingFloor> parkingFloors;

    private ParkingLot(int numFloors, ParkingSpotMap spotMap){
        this.numFloors = numFloors;
        this.spotMap = spotMap;
        this.parkingFloors = new ArrayList<>();

        initializeParkingLot();
    }

    public int getNumFloors() {
        return numFloors;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    private void initializeParkingLot(){
        for(int floor = 1; floor <= numFloors; floor++){

            List<ParkingSpot> parkingSpots = new ArrayList<>();

            for(Map.Entry<VehicleType, Integer> entry: spotMap.getSpotsPerVehicleType().entrySet()){
                VehicleType vehicleType = entry.getKey();
                int count = entry.getValue();

                for(int spot = 1; spot <= count; spot++){
                    parkingSpots.add(new ParkingSpot(vehicleType, spot));
                }
            }

            parkingFloors.add(new ParkingFloor(floor, parkingSpots));

            System.out.println("parking floor " + floor + " initialised with " + parkingSpots.size() + " spots");
        }
    }

    public static ParkingLot getInstance(int numFloors, ParkingSpotMap spotMap){
        if(instance == null){
            instance = new ParkingLot(numFloors, spotMap);
        }
        return instance;
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime, PricingType pricingType){
        for(ParkingFloor floor : parkingFloors){
            ParkingSpot spot = floor.getAvailableSpot(vehicle.getVehicleType());

            if(spot != null){
                Ticket ticket = new Ticket.TicketBuilder()
                                    .setEntryTime(entryTime)
                                    .setVehicle(vehicle)
                                    .setPricingType(pricingType)
                                    .setParkingSpot(spot)
                                    .build();
                
                return ticket;
            }
        }
        System.out.println("No parking spot available for vehicle type: " + vehicle.getVehicleType());
        return null;
    }

    public Ticket unParkVehicle(Ticket ticket, LocalDateTime exitTime) {
        ticket.closeTicket(exitTime);
        ticket.getParkingSpot().vacate();

        return ticket;
    }
}
