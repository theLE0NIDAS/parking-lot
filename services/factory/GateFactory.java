package services.factory;

import entities.EntryGate;
import entities.ExitGate;
import entities.Gate;
import enums.GateType;
import services.ParkingLot;

public class GateFactory {
    
    public static Gate getGate(GateType gateType, ParkingLot parkingLot){
        if(gateType == GateType.ENTRY){
            return new EntryGate(parkingLot);
        }
        else if(gateType == GateType.ENTRY){
            return new ExitGate(parkingLot);
        }

        throw new IllegalArgumentException(
            "Unsupported GateType" + gateType
        );
    }
}
