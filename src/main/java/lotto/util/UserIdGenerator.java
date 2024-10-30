package lotto.util;

import java.util.concurrent.atomic.AtomicInteger;

public class UserIdGenerator {

    private static final AtomicInteger idCounter = new AtomicInteger(-1);

    public static int generateId() {
        return idCounter.incrementAndGet();
    }
}
