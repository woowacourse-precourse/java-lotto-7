package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Prize, Integer> prizeCount = new HashMap<>();

    public LottoResult() {
        for (Prize prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }
    }

    public void recordPrize(Prize prize) {
        prizeCount.put(prize, prizeCount.get(prize) + 1);
    }

}
