package lotto.models;

import lotto.utils.Prize;

import java.util.*;

public class Statistics {

    private final Map<Prize, Integer> statistics;

    public Statistics() {
        statistics = new HashMap<>();
        initialize();
    }

    public void initialize() {
        for (Prize prize : Prize.values()) {
            statistics.put(prize, 0);
        }
    }

    public void increment(Prize prize) {
        statistics.put(prize, statistics.get(prize) + 1);
    }

    public int getCount(Prize prize) {
        return statistics.get(prize);
    }

    public Map<Prize, Integer> get() {
        return statistics;
    }


}
