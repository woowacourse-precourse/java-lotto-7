package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class PrizeManager {
    private Map<Integer, Long> prizeMoneyMap;

    public PrizeManager() {
        this.prizeMoneyMap = new HashMap<>();
        initializePrizeMoney();
    }

    private void initializePrizeMoney() {
        for (Prize prize : Prize.values()) {
            if (prize.getMatchCount() <= 6) {
                prizeMoneyMap.put(prize.getMatchCount(), prize.getPrizeAmount());
            }
        }
    }

    public long getPrizeMoney(int matchCount) {
        return prizeMoneyMap.getOrDefault(matchCount, 0L);
    }
}
