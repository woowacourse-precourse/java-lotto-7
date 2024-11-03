package lotto.application.ticket.service;

import java.util.concurrent.atomic.AtomicLong;
import lotto.application.common.IdGenerator;

public class TicketIdGenerator implements IdGenerator {
    private final AtomicLong sequence = new AtomicLong(0L);

    @Override
    public Long generate() {
        return sequence.incrementAndGet();
    }

}
