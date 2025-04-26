package designpatterns.factory_payment.abstract_factory;

import designpatterns.factory_payment.Payment_enum;
import designpatterns.factory_payment.abstract_factory.abstract_methods.PaymentMethods;
import designpatterns.factory_payment.abstract_factory.abstract_methods.ProcessPayment;
import designpatterns.factory_payment.abstract_factory.abstract_methods.RefundPayment;
import designpatterns.factory_payment.abstract_factory.concrete_classes.Payment;

public class main {
    public static void main(String[] args) {
        Payment payment=new Payment(Payment_enum.PAYPAL);
        ProcessPayment processPayment=payment.getinstance().process();
        RefundPayment refundPayment=payment.getinstance().refund();
    }
}
