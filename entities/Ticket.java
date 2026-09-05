package entities;

import java.time.LocalDateTime;

import enums.PricingType;
import services.factory.PricingFactory;

public class Ticket {
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double amount;
    private Vehicle vehicle;
    private PricingType pricingType;
    private ParkingSpot parkingSpot;

    public double getAmount() {
        return amount;
    }

    public ParkingSpot getParkingSpot(){
        return parkingSpot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    private Ticket(TicketBuilder builder){
        this.entryTime = builder.entryTime;
        this.vehicle = builder.vehicle;
        this.pricingType = builder.pricingType;
        this.parkingSpot = builder.parkingSpot;
    }

    public void closeTicket(LocalDateTime exitTime) {
        this.exitTime = exitTime;
        this.amount = new PricingFactory().getPricingStrategy(pricingType).calcFare(vehicle.getVehicleType(), entryTime, exitTime);
    }

    public static class TicketBuilder {
        private LocalDateTime entryTime;
        private Vehicle vehicle;
        private PricingType pricingType = PricingType.TIME_BASED;
        private ParkingSpot parkingSpot;

        public TicketBuilder(){};
        public TicketBuilder setEntryTime(LocalDateTime entryTime){
            this.entryTime = entryTime;
            return this;
        }
        public TicketBuilder setVehicle(Vehicle vehicle){
            this.vehicle = vehicle;
            return this;
        }
        public TicketBuilder setPricingType(PricingType pricingType){
            this.pricingType = pricingType;
            return this;
        }
        public TicketBuilder setParkingSpot(ParkingSpot parkingSpot){
            this.parkingSpot = parkingSpot;
            return this;
        }
        public Ticket build(){
            return new Ticket(this);
        }
    }

    @Override
    public String toString() {
        return "\n" +
            "========================================\n" +
            "              PARKING TICKET             \n" +
            "========================================\n" +
            " Vehicle Number : " + vehicle.getVehicleNumber() + "\n" +
            " Vehicle Type   : " + vehicle.getVehicleType() + "\n" +
            " Parking Spot   : " + parkingSpot.getSpotNumber() + "\n" +
            " Entry Time     : " + entryTime + "\n" +
            " Exit Time      : " + exitTime + "\n" +
            " Pricing Type   : " + pricingType + "\n" +
            " Amount         : Rs." + String.format("%.2f", amount) + "\n" +
            "========================================\n";
    }

}
