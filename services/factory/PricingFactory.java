package services.factory;

import services.strategy.PricingStrategy;
import services.strategy.pricing.EventBasedPricing;
import services.strategy.pricing.TimeBasedPricing;
import enums.PricingType;

public class PricingFactory {
    
    public PricingStrategy getPricingStrategy(PricingType pricingType){
        if(pricingType == PricingType.EVENT_BASED){
            return new EventBasedPricing();
        }
        else if(pricingType == PricingType.TIME_BASED){
            return new TimeBasedPricing();
        }

        throw new IllegalArgumentException(
            "Unsupported PricingType" + pricingType
        );
    }
}
