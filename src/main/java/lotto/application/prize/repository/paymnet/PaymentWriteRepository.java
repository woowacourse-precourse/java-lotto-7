package lotto.application.prize.repository.paymnet;

import java.util.concurrent.ConcurrentHashMap;
import lotto.application.ticket.domain.payment.Payment;

public class PaymentWriteRepository {
    private final ConcurrentHashMap repository = new ConcurrentHashMap<Long, Payment>();

    public PaymentWriteRepository() {
    }

    public Long save(Payment payment) {
        repository.put(payment.getId(), payment);

        return payment.getId();
    }
}
