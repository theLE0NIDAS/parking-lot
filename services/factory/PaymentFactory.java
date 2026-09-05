package services.factory;

import enums.PaymentMode;
import services.strategy.PaymentStrategy;
import services.strategy.payment.CreditCardPayment;
import services.strategy.payment.UPIPayment;

public class PaymentFactory {
    
    public static PaymentStrategy getPaymentStrategy(PaymentMode paymentMode){
        if(paymentMode == PaymentMode.UPI){
            return new UPIPayment();
        }
        else if(paymentMode == PaymentMode.CREDIT_CARD){
            return new CreditCardPayment();
        }
        
        throw new IllegalArgumentException(
            "Unsupported PaymentMode" + paymentMode
        );
    }
}
