package lotto.application.prize.service;

import static lotto.application.prize.constants.Constants.ZERO;

import java.util.concurrent.atomic.AtomicLong;
import lotto.application.common.IdGenerator;

public class PrizeIdGenerator implements IdGenerator {
    private final AtomicLong sequence = new AtomicLong(ZERO);

    @Override
    public Long generate() {
        return sequence.incrementAndGet();
    }

}
