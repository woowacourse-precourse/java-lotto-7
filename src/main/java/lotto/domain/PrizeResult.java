package lotto.domain;

import java.util.EnumMap;

public class PrizeResult {
    private EnumMap<Prize, Integer> prizeResult = new EnumMap<>(Prize.class);

    public void winPrize(Prize prize) {
        int prizeCount = prizeResult.getOrDefault(prize, 0);
        prizeResult.put(prize, prizeCount);
    }

    public EnumMap<Prize, Integer> getPrizeResult() {
        return prizeResult;
    }
}
