package services.strategy.pricing;

import java.time.Duration;
import java.time.LocalDateTime;

import enums.VehicleType;
import services.strategy.PricingStrategy;

public class EventBasedPricing implements PricingStrategy {
    
    
    @Override
    public double calcFare(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime){
        long minutes = Duration.between(entryTime, exitTime).toMinutes();
        long hours = (long) Math.ceil(minutes / 60.0);
        
        return 20.0 * hours;
    }
}
