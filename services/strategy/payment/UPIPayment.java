package services.strategy.payment;

import services.strategy.PaymentStrategy;

public class UPIPayment implements PaymentStrategy {
    
    @Override
    public String pay(double amount){
        return "Paid amount Rs. " + amount + "via UPI";
    }
}
