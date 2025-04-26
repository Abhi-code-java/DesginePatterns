package designpatterns.factory_payment.abstract_factory.concrete_classes;

import designpatterns.factory_payment.abstract_factory.abstract_methods.PaymentMethods;
import designpatterns.factory_payment.abstract_factory.abstract_methods.ProcessPayment;
import designpatterns.factory_payment.abstract_factory.abstract_methods.RefundPayment;
import designpatterns.factory_payment.abstract_factory.payment_methods.bitcoin.BitCoinProcessPayment;
import designpatterns.factory_payment.abstract_factory.payment_methods.bitcoin.BitCointRefundPayment;

public class BitCoin implements PaymentMethods {
    @Override
    public ProcessPayment process() {
        return new BitCoinProcessPayment();
    }

    @Override
    public RefundPayment refund() {
        return new BitCointRefundPayment();
    }
}
