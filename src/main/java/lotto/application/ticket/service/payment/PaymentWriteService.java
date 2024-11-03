package lotto.application.ticket.service.payment;

import lotto.application.common.IdGenerator;
import lotto.application.common.ThousandWons.ThousandWons;
import lotto.application.prize.repository.paymnet.PaymentWriteRepository;
import lotto.application.ticket.domain.payment.LottoPrice;
import lotto.application.ticket.domain.payment.LottoQuantity;
import lotto.application.ticket.domain.payment.Payment;
import lotto.application.ticket.domain.payment.PaymentResult;

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
