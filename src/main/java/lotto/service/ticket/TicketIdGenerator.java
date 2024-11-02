package lotto.service.ticket;

import java.util.concurrent.atomic.AtomicLong;
import lotto.service.IdGenerator;

public class TicketIdGenerator implements IdGenerator {
    private final AtomicLong sequence = new AtomicLong(0L);

    @Override
    public Long generate() {
        return sequence.incrementAndGet();
    }
    
}
