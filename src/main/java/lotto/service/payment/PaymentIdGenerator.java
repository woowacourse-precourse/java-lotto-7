package lotto.service.payment;

import java.util.concurrent.atomic.AtomicLong;
import lotto.service.IdGenerator;

public class PaymentIdGenerator implements IdGenerator {

    private final AtomicLong sequence = new AtomicLong(0L);

    @Override
    public Long generate() {
        return sequence.incrementAndGet();
    }
}
