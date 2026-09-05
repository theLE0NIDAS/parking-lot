package entities;

import java.util.concurrent.atomic.AtomicBoolean;

import enums.VehicleType;

public class ParkingSpot {
    private int spotNumber;
    private VehicleType vehicleType;
    private AtomicBoolean occupied;

    public ParkingSpot(VehicleType vehicleType, int spotNumber){
        this.vehicleType = vehicleType;
        this.occupied = new AtomicBoolean(false);
        this.spotNumber = spotNumber;
    }

    public boolean tryOccupy(){
        return occupied.compareAndSet(false, true);
    }

    public boolean isOccupied(){
        return occupied.get();
    }

    public void vacate(){
        occupied.set(false);
    }

    public VehicleType getSpotType(){
        return vehicleType;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}
