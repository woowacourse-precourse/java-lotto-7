package lotto;

import java.util.*;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCount;
    private final int purchaseAmount;

    public LottoResult(int purchaseAmount) {
        this.rankCount = new EnumMap<>(LottoRank.class);
        this.purchaseAmount = purchaseAmount;
        initializeRankCount();
    }

    private void initializeRankCount() {
        for (LottoRank rank : LottoRank.values()) {
            rankCount.put(rank, 0);
        }
    }

    public void addWinningResult(Lotto lotto, WinningNumber winningNumber) {
        List<Integer> winningNumbers = winningNumber.getWinningLotto().getNumbers();
        int matchCount = countMatch(lotto, winningNumbers);
        boolean matchBonus = isMatchBonus(lotto, winningNumber.getBonusNumber());

        LottoRank rank = LottoRank.calculate(matchCount, matchBonus);
        rankCount.merge(rank, 1, Integer::sum);
    }

    private int countMatch(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isMatchBonus(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .sorted(Comparator.comparingInt(LottoRank::getPrize))
                .forEach(rank -> System.out.printf("%s - %d개%n",
                        rank.getMessage(), rankCount.get(rank)));

        printProfitRate();
    }

    private void printProfitRate() {
        double totalPrize = calculateTotalPrize();
        double profitRate = (totalPrize / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private long calculateTotalPrize() {
        return rankCount.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}