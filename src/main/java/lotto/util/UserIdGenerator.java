package lotto.util;

import java.util.concurrent.atomic.AtomicInteger;

public class UserIdGenerator {

    private static AtomicInteger idCounter = new AtomicInteger(-1);

    public static void init() {
        idCounter = new AtomicInteger(-1);
    }

    public static int generateId() {
        return idCounter.incrementAndGet();
    }
}
