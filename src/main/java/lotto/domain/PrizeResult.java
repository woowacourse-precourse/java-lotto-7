package lotto.domain;

import java.util.EnumMap;

public class PrizeResult {
    private final EnumMap<Prize, Integer> prizeResult = new EnumMap<>(Prize.class);

    public PrizeResult() {
        for (Prize prize : Prize.values()) {
            // NullPointerException을 방지하기 위해 0으로 초기화
            prizeResult.put(prize, 0);
        }
    }

    public void winPrize(Prize prize) {
        prizeResult.compute(prize, (k, prizeCount) -> prizeCount + 1);
    }

    public EnumMap<Prize, Integer> getPrizeResult() {
        return prizeResult;
    }
}
