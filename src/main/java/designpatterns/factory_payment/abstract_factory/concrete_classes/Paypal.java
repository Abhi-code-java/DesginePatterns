package designpatterns.factory_payment.abstract_factory.concrete_classes;

import designpatterns.factory_payment.abstract_factory.abstract_methods.PaymentMethods;
import designpatterns.factory_payment.abstract_factory.abstract_methods.ProcessPayment;
import designpatterns.factory_payment.abstract_factory.abstract_methods.RefundPayment;
import designpatterns.factory_payment.abstract_factory.payment_methods.paypal.PaypalProcessPayemnt;
import designpatterns.factory_payment.abstract_factory.payment_methods.paypal.PaypalRefundPayment;

public class Paypal implements PaymentMethods {
    @Override
    public ProcessPayment process() {
        return new PaypalProcessPayemnt();
    }

    @Override
    public RefundPayment refund() {
        return new PaypalRefundPayment();
    }
}
