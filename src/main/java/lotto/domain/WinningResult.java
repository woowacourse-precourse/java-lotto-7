package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    Map<WinningCondition, List<Lotto>> resultMap;

    public WinningResult(Lottos purchasedLottos, Lotto winningNumbers, int bonusNumber) {
        this.resultMap = initializeResultMap();
        purchasedLottos.getLottos().forEach(lotto -> processLotto(lotto, winningNumbers, bonusNumber));
    }

    public double getProfitRate(Amount purchasedAmount) {
        long totalWinningAmount = resultMap.keySet().stream()
                .map(key -> key.getRewardAmount() * resultMap.get(key).size())
                .mapToLong(Integer::toUnsignedLong).sum();
        double profitRate = (double) totalWinningAmount / purchasedAmount.getValue() * 100;
        return Math.round(profitRate * 100.0) / 100.0;
    }

    private Map<WinningCondition, List<Lotto>> initializeResultMap() {
        Map<WinningCondition, List<Lotto>> map = new EnumMap<>(WinningCondition.class);
        WinningCondition.getAllConditions().forEach(condition -> map.put(condition, new ArrayList<>()));
        return map;
    }

    private void processLotto(Lotto lotto, Lotto winningNumbers, int bonusNumber) {
        long matchCount = lotto.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
        boolean containsBonus = lotto.getNumbers().contains(bonusNumber);
        addLottoToResultMap(lotto, matchCount, containsBonus);
    }

    private void addLottoToResultMap(Lotto lotto, long matchCount, boolean containsBonus) {
        WinningCondition.getAllConditions().stream()
                .filter(condition -> isMatchingCondition(condition, matchCount, containsBonus))
                .findFirst()
                .ifPresent(condition -> resultMap.get(condition).add(lotto));
    }

    private boolean isMatchingCondition(WinningCondition condition, long matchCount, boolean containsBonus) {
        return condition.getWinningNumberCount() == matchCount
                && (!condition.mustIncludeBonusNumber() || containsBonus);
    }

    public Map<WinningCondition, List<Lotto>> getResultMap() {
        return resultMap;
    }
}
