package designpatterns.factory_payment.abstract_factory.abstract_methods;

public interface PaymentMethods {
    ProcessPayment process();
    RefundPayment refund();
}
