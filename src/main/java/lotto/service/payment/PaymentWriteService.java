package lotto.service.payment;

import lotto.domain.common.ThousandWons.ThousandWons;
import lotto.domain.payment.LottoPrice;
import lotto.domain.payment.LottoQuantity;
import lotto.domain.payment.Payment;
import lotto.domain.payment.PaymentResult;
import lotto.repository.paymnet.PaymentWriteRepository;
import lotto.service.IdGenerator;

public class PaymentWriteService {

    private final PaymentWriteRepository paymentWriteRepository;

    private final IdGenerator idGenerator;

    public PaymentWriteService(PaymentWriteRepository paymentWriteRepository, IdGenerator idGenerator) {
        this.paymentWriteRepository = paymentWriteRepository;
        this.idGenerator = idGenerator;
    }

    public LottoQuantity pay(ThousandWons money) {
        Payment payment = initialize(money);

        Payment validatedPayment = payment.validate();
        PaymentResult result = validatedPayment.execute();
        paymentWriteRepository.save(result.getCompletedPayment());

        return result.getLottoCount();
    }

    private Payment initialize(ThousandWons money) {
        return Payment.initialize(idGenerator.generate(), money, LottoPrice.basic());
    }

}
