package designpatterns.factory_payment.abstract_factory.concrete_classes;

import designpatterns.factory_payment.abstract_factory.abstract_methods.PaymentMethods;
import designpatterns.factory_payment.abstract_factory.abstract_methods.ProcessPayment;
import designpatterns.factory_payment.abstract_factory.abstract_methods.RefundPayment;
import designpatterns.factory_payment.abstract_factory.payment_methods.creditcard.CreditCardProcessPayment;
import designpatterns.factory_payment.abstract_factory.payment_methods.creditcard.CreditCardRedundPayment;

public class CreditCard implements PaymentMethods {
    @Override
    public ProcessPayment process() {
        return new CreditCardProcessPayment();
    }

    @Override
    public RefundPayment refund() {
        return new CreditCardRedundPayment();
    }
}
