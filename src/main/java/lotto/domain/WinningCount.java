package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.dto.WinningResult;

public class WinningCount {
    private final Map<WinningLottoCriteria, Integer> winning;

    public WinningCount(WinningNumbers winningNumbers, List<Lotto> lottos) {
        this.winning = calculate(winningNumbers, lottos);
    }

    private Map<WinningLottoCriteria, Integer> calculate(WinningNumbers winningNumbers, List<Lotto> lottos) {
        Map<WinningLottoCriteria, Integer> winning = Arrays.stream(WinningLottoCriteria.values())
                .collect(Collectors.toMap(criteria -> criteria, criteria -> 0, (existing, replacement) -> existing,
                        LinkedHashMap::new));

        for (Lotto lotto : lottos) {
            WinningResult winningResult = winningNumbers.findWinningNumber(lotto);

            WinningLottoCriteria.findPrize(winningResult.correctNumberCnt(), winningResult.correctBonus())
                    .ifPresent(prize -> winning.put(prize, winning.get(prize) + 1));
        }

        return winning;
    }

    public List<String> getWinning() {
        return winning.entrySet().stream()
                .map(entry -> String.format("%s - %d개", entry.getKey(), entry.getValue()))
                .toList();
    }

    public double getRateOfReturn(PurchaseAmount purchaseAmount) {
        long profit = winning.entrySet().stream()
                .mapToLong(entry -> {
                    WinningLottoCriteria prize = entry.getKey();
                    return prize.getMoney() * entry.getValue();
                })
                .sum();

        return profit / (double) purchaseAmount.getMoney() * 100;
    }
}
