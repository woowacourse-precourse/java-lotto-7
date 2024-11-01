package lotto.service;

import lotto.LottoCount;
import lotto.ThousandWons;
import lotto.domain.Payment;
import lotto.repository.PaymentRepository;

public class PaymentService {

    private final PaymentRepository paymentRepository;

    private final IdGenerator idGenerator;

    public PaymentService(PaymentRepository paymentRepository, IdGenerator idGenerator) {
        this.paymentRepository = paymentRepository;
        this.idGenerator = idGenerator;
    }

    //TODO: Payment - 지불하라
    //TODO: PaymentRepository - 저장하라
    public LottoCount pay(ThousandWons krMoney) {
        Payment payment = createPayment(krMoney);
        processPayment(payment);
        return calculateLottoCount(payment);
    }

    private Payment createPayment(ThousandWons krMoney) {
        return Payment.of(krMoney);
    }

    private void processPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    private LottoCount calculateLottoCount(Payment payment) {
        return payment.success();
    }
}
