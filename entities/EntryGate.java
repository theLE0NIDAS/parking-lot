package entities;

import java.time.LocalDateTime;

import enums.GateType;
import enums.PricingType;
import services.ParkingLot;

public class EntryGate extends Gate {
    private ParkingLot parkingLot;
    
    public EntryGate(ParkingLot parkingLot){
        super(GateType.ENTRY);
        this.parkingLot = parkingLot;
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime, PricingType pricingType){
        return parkingLot.parkVehicle(vehicle, entryTime, pricingType);
    }
}
