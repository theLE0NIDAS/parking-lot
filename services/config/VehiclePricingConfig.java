package services.config;

import java.util.Map;

import enums.VehicleType;

public class VehiclePricingConfig {

    private final Map<VehicleType, Double> hourlyRates;

    public VehiclePricingConfig(Map<VehicleType, Double> hourlyRates) {
        this.hourlyRates = hourlyRates;
    }

    public double getRate(VehicleType vehicleType) {
        Double rate = hourlyRates.get(vehicleType);

        if (rate == null) {
            throw new IllegalArgumentException(
                "No rate configured for " + vehicleType
            );
        }

        return rate;
    }
}
