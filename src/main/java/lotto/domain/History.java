package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.vo.LottoPrizeMoney;

public class History {

    private final Map<LottoPrizeMoney, Integer> winnings;

    public History() {
        winnings = createWinnins();
    }

    private Map<LottoPrizeMoney, Integer> createWinnins() {
        Map<LottoPrizeMoney, Integer> winnings = new LinkedHashMap<>();

        for (LottoPrizeMoney key : LottoPrizeMoney.values()) {
            winnings.put(key, 0);
        }
        return winnings;
    }

    public void addHistory(long hitCount, long bonusCount) {
        LottoPrizeMoney key = LottoPrizeMoney.findByHitCount(hitCount, bonusCount);
        winnings.put(key, winnings.getOrDefault(key, 0) + 1);
    }

    public List<String> extractHistory() {
        List<String> result = new ArrayList<>();

        winnings.forEach((key, value) -> result.add(key.getResult(value)));
        result.removeIf(String::isEmpty);
        return result;
    }

    public Long getTotalPrizeMoney() {
        List<Long> totalPrizeMoney = new ArrayList<>();

        winnings.forEach((key, value) -> {
            totalPrizeMoney.add(key.getTotalPrizeMoney(value));
        });

        return totalPrizeMoney.stream().reduce(0L, Long::sum);
    }
}
