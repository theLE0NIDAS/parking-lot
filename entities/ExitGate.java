package entities;
import java.time.LocalDateTime;

import enums.GateType;
import services.ParkingLot;

public class ExitGate extends Gate {
    private ParkingLot parkingLot;
    
    public ExitGate(ParkingLot parkingLot){
        super(GateType.EXIT);
        this.parkingLot = parkingLot;
    }

    public Ticket unParkVehicle(Ticket ticket, LocalDateTime exitTime){
        return parkingLot.unParkVehicle(ticket, exitTime);
    }
}
