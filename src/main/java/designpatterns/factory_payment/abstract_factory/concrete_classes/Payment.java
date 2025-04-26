package designpatterns.factory_payment.abstract_factory.concrete_classes;

import designpatterns.factory_payment.Payment_enum;
import designpatterns.factory_payment.abstract_factory.abstract_methods.PaymentMethods;
import designpatterns.factory_payment.enumfactory.EnumFactory;

public class Payment {
    private int amount;
    private String customerName;
    private Payment_enum paymentEnum;

    public Payment(Payment_enum paymentEnum) {
        this.paymentEnum = paymentEnum;
    }
    public PaymentMethods getinstance(){
        return new EnumFactory().getInstance(paymentEnum);
    }
}
