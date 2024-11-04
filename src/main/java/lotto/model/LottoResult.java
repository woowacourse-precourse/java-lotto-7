package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankCounts;

    public LottoResult(List<Lotto> lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.rankCounts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
        calculateResults(lottos, winningNumbers, bonusNumber);
    }

    private void calculateResults(List<Lotto> lottos, WinningNumbers winningNumbers,
                                  BonusNumber bonusNumber) {
        for (Lotto lotto : lottos) {
            Rank rank = calculateRank(lotto, winningNumbers, bonusNumber);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
    }

    private Rank calculateRank(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbersList = winningNumbers.getNumbers();

        long matchCount = lottoNumbers.stream()
                .filter(winningNumbersList::contains)
                .count();

        boolean matchBonus = lottoNumbers.contains(bonusNumber.getNumber());

        return Rank.valueOf((int) matchCount, matchBonus);
    }

    public int getCountByRank(Rank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public double calculateProfit(Money money) {
        if (money == null) {
            throw new IllegalStateException("금액이 초기화되지 않았습니다.");
        }
        if (rankCounts == null || rankCounts.isEmpty()) {
            throw new IllegalStateException("당첨 결과가 계산되지 않았습니다.");
        }

        long totalPrize = calculateTotalPrize();
        double profitRate = (totalPrize * 100.0) / money.getAmount();
        return Math.round(profitRate * 10) / 10.0; // 소수점 둘째 자리에서 반올림
    }

    private long calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
