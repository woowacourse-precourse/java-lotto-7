package lotto.service.payment;

import lotto.domain.common.ThousandWons.ThousandWons;
import lotto.domain.payment.LottoPrice;
import lotto.domain.payment.LottoQuantity;
import lotto.domain.payment.Payment;
import lotto.domain.payment.PaymentResult;
import lotto.repository.paymnet.PaymentRepository;
import lotto.service.IdGenerator;

public class PaymentService {

    private final PaymentRepository paymentRepository;

    private final IdGenerator idGenerator;

    public PaymentService(PaymentRepository paymentRepository, IdGenerator idGenerator) {
        this.paymentRepository = paymentRepository;
        this.idGenerator = idGenerator;
    }

    public LottoQuantity pay(ThousandWons money) {
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
