package services.strategy.payment;

import services.strategy.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    
    @Override
    public String pay(double amount){
        return "Paid amount Rs. " + amount + "via Credit Card";
    }
}
