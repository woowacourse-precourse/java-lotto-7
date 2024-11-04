package lotto.application.ticket.service.payment;

import static lotto.application.ticket.constants.Constants.INITIAL_ID;

import java.util.concurrent.atomic.AtomicLong;
import lotto.application.common.IdGenerator;

public class PaymentIdGenerator implements IdGenerator {

    private final AtomicLong sequence = new AtomicLong(INITIAL_ID);

    @Override
    public Long generate() {
        return sequence.incrementAndGet();
    }
}
