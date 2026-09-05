package services.strategy;

import java.time.LocalDateTime;

import enums.VehicleType;

public interface PricingStrategy {

    public double calcFare(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime);
}
