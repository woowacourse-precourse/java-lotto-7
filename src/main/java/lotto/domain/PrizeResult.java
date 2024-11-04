package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class PrizeResult {

    private static final int DEFAULT_VALUE = 0;
    
    private final Map<Prize, Integer> prizes;

    public PrizeResult() {
        prizes = new EnumMap<>(Prize.class);
        Arrays.stream(Prize.values())
                .forEach(prize -> prizes.put(prize, DEFAULT_VALUE));
    }

    public void calculatePrizes(WinningLotto winningLotto, Lottos lottos) {
        lottos.lottos().stream()
                .map(lotto -> Prize.determinePrize(
                        lotto.getMatchingCountWith(winningLotto.winningNumbers()),
                        lotto.containsBonusNumber(winningLotto.bonusNumber())))
                .forEach(this::updatePrizeResult);
    }

    public int getSumOfProfit() {
        return Arrays.stream(Prize.values())
                .mapToInt(prize -> prizes.get(prize) * prize.getPrizeMoney())
                .sum();
    }

    public int getPrizeCount(Prize prize) {
        return prizes.get(prize);
    }

    private void updatePrizeResult(Prize prize) {
        prizes.put(prize, prizes.get(prize) + 1);
    }
}
