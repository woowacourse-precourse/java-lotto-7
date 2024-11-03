package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrizeCount {
    private Map<Prize, Integer> prizeCount;

    public PrizeCount() {
        this.prizeCount = new HashMap<>();
        Arrays.stream(Prize.values())
                .forEach(prize -> this.prizeCount.put(prize, 0));
    }

    public void increaseCount(Prize prize) {
        this.prizeCount.put(prize, this.prizeCount.get(prize) + 1);
    }

    public Map<Prize, Integer> getPrizeCount() {
        return new HashMap<>(prizeCount);
    }
}
