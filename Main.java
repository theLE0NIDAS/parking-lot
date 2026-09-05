import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import entities.EntryGate;
import entities.ExitGate;
import entities.Gate;
import entities.ParkingSpotMap;
import entities.Ticket;
import entities.Vehicle;
import enums.GateType;
import enums.PaymentMode;
import enums.PricingType;
import enums.VehicleType;
import services.ParkingLot;
import services.PaymentProcessor;
import services.factory.GateFactory;
import services.factory.VehicleFactory;
import services.strategy.PricingStrategy;

public class Main {
    public static void main(String[] args) {
        Map<VehicleType, Integer> spotMap = new HashMap<>();
        spotMap.put(VehicleType.BIKE, 2);
        spotMap.put(VehicleType.CAR, 2);
        
        ParkingSpotMap spotsPerVehicleType = new ParkingSpotMap(spotMap);
        

        ParkingLot parkingLot = ParkingLot.getInstance(1, spotsPerVehicleType);

        Vehicle v1 = VehicleFactory.getVehicle(VehicleType.BIKE, "AB12CD1234");
        Vehicle v2 = VehicleFactory.getVehicle(VehicleType.BIKE, "AB12CD1235");
        Vehicle v3 = VehicleFactory.getVehicle(VehicleType.BIKE, "AB12CD1236");

        Vehicle v4 = VehicleFactory.getVehicle(VehicleType.CAR, "AB12CD1237");

        EntryGate en1 = new EntryGate(parkingLot);
        ExitGate ex1 = new ExitGate(parkingLot);

        LocalDateTime t1 = LocalDateTime.now();
        LocalDateTime t2 = t1.plusHours(2);

        Ticket ticket1 = en1.parkVehicle(v1, t1, PricingType.TIME_BASED);
        Ticket ticket2 = en1.parkVehicle(v2, t1, PricingType.EVENT_BASED);

        
        ticket1 = ex1.unParkVehicle(ticket1, t2);
        ticket2 = ex1.unParkVehicle(ticket2, t2);
        
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        
        paymentProcessor.setPaymentStrategy(PaymentMode.UPI).pay(ticket1.getAmount());
        paymentProcessor.setPaymentStrategy(PaymentMode.UPI).pay(ticket2.getAmount());
        
        System.out.println(ticket1);
        System.out.println(ticket2);
    }
}