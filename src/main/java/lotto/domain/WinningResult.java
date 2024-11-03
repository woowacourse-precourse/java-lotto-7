package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private final Map<Prize, Integer> winning;

    public WinningResult(WinningLotto winningNumbers, List<Lotto> lottos) {
        this.winning = calculate(winningNumbers, lottos);
    }

    private Map<Prize, Integer> calculate(WinningLotto winningNumbers, List<Lotto> lottos) {
        Map<Prize, Integer> winning = createDefaultResult();

        lottos.stream()
                .map(winningNumbers::findWinningPrize)
                .forEach(winningResult -> winningResult.ifPresent(prize -> winning.put(prize, winning.get(prize) + 1)));

        return winning;
    }

    private Map<Prize, Integer> createDefaultResult() {
        Map<Prize, Integer> winning = new LinkedHashMap<>();
        Arrays.stream(Prize.values())
                .forEach(prize -> winning.put(prize, 0));

        return winning;
    }

    public Map<Prize, Integer> getWinning() {
        return Collections.unmodifiableMap(winning);
    }

    public double getRateOfReturn(PurchaseAmount purchaseAmount) {
        long profit = winning.entrySet().stream()
                .mapToLong(entry -> {
                    Prize prize = entry.getKey();
                    return prize.getMoney() * entry.getValue();
                })
                .sum();

        return profit / (double) purchaseAmount.getMoney() * 100;
    }
}
