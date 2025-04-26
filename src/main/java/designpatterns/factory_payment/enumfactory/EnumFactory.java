package designpatterns.factory_payment.enumfactory;

import designpatterns.factory_payment.Payment_enum;
import designpatterns.factory_payment.abstract_factory.abstract_methods.PaymentMethods;
import designpatterns.factory_payment.abstract_factory.concrete_classes.BitCoin;
import designpatterns.factory_payment.abstract_factory.concrete_classes.CreditCard;
import designpatterns.factory_payment.abstract_factory.concrete_classes.Payment;
import designpatterns.factory_payment.abstract_factory.concrete_classes.Paypal;

public class EnumFactory {
    public  PaymentMethods getInstance(Payment_enum paymentEnum){
        switch (paymentEnum){
            case PAYPAL :
                return new Paypal();
            case BIT_COIN:
                return new BitCoin();
            case CREDIT_CARD:
                return new CreditCard();
            default:
                throw new IllegalArgumentException("not payment method found");
        }
    }
}
