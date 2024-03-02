package controller.payment;

import model.bl.payment.PaymentService;
import model.entity.PaymentInfo;
import view.payment.PaymentView;

public class PaymentController {

    private PaymentService paymentService;
    private PaymentView paymentView;

    public PaymentController(PaymentService paymentService, PaymentView paymentView) {
        this.paymentService = paymentService;
        this.paymentView = paymentView;
    }

    public void processPayment() {
        PaymentInfo paymentInfo = paymentView.promptForPaymentInfo();
        paymentService.processPayment(paymentInfo);
    }
}
