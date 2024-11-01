package lotto.service;

import lotto.LottoCount;
import lotto.ThousandWons;
import lotto.domain.LottoPrice;
import lotto.domain.Payment;
import lotto.domain.PaymentResult;
import lotto.repository.PaymentRepository;

public class PaymentService {

    private final PaymentRepository paymentRepository;

    private final IdGenerator idGenerator;

    public PaymentService(PaymentRepository paymentRepository, IdGenerator idGenerator) {
        this.paymentRepository = paymentRepository;
        this.idGenerator = idGenerator;
    }

    public LottoCount pay(ThousandWons money) {
        Payment payment = initialize(money);

        Payment validatedPayment = payment.validate();
        PaymentResult result = validatedPayment.execute();
        paymentRepository.save(result.getCompletedPayment());

        return result.getLottoCount();
    }

    private Payment initialize(ThousandWons money) {
        return Payment.initialize(idGenerator.generate(), money, LottoPrice.basic());
    }

}
