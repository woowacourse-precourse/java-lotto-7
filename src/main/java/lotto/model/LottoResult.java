package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<Prize, Integer> prizeCounts = new EnumMap<>(Prize.class);
    private int lottoCost;
    private int totalPrize;

    public LottoResult(List<Integer> winningNumbers, int bonusNumber, int lottoCost) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottoCost = lottoCost;
        initializeRankCounts();
    }

    private void initializeRankCounts() {
        for (Prize prize : Prize.values()) {
            prizeCounts.put(prize, 0);
        }
    }

    public void increasePrizeCount(Prize prize) {
        prizeCounts.put(prize, prizeCounts.get(prize) + 1);
    }

    public int getRankCount(Prize prize) {
        return prizeCounts.getOrDefault(prize, 0);
    }

    public void setTotalPrize(int totalPrize) {
        this.totalPrize = totalPrize;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getLottoCost() {
        return lottoCost;
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
