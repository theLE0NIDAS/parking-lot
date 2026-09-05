package services;
import enums.PaymentMode;
import services.factory.PaymentFactory;
import services.strategy.PaymentStrategy;

public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor setPaymentStrategy(PaymentMode paymentMode){
        this.paymentStrategy = PaymentFactory.getPaymentStrategy(paymentMode);
        return this;
    }

    public String pay(double amount){
        if(paymentStrategy == null){
            throw new IllegalStateException("Payment strategy not set");
        }
        return paymentStrategy.pay(amount);
    }
}
