package lotto.domain;

import java.util.EnumMap;
import java.util.List;

public class LottoSummary {

    private final EnumMap<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);

    public LottoSummary(List<Lotto> lottoTickets, WinningNumber winningNumber) {
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
        calculateLottoRank(lottoTickets, winningNumber);
    }

    private void calculateLottoRank(List<Lotto> lottoTickets, WinningNumber winningNumber) {
        for (Lotto lotto : lottoTickets) {
            int correctCount = winningNumber.calculateCorrectCount(lotto);
            findOutRank(correctCount, winningNumber, lotto);
        }
    }

    private void findOutRank(int correctCount, WinningNumber winningNumber, Lotto lotto) {
        if (correctCount == 3) {
            incrementCount(LottoRank.FIFTH_RANK);
        } else if (correctCount == 4) {
            incrementCount(LottoRank.FOURTH_RANK);
        } else if (correctCount == 5) {
            if (winningNumber.correctBonus(lotto)) {
                incrementCount(LottoRank.SECOND_RANK);
            }
            incrementCount(LottoRank.THIRD_RANK);
        } else if (correctCount == 6) {
            incrementCount(LottoRank.FIRST_RANK);
        }
    }

    private void incrementCount(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public double calculateRateOfReturn(Budget budget) {
        int totalPrize = calculateTotalPrize();
        return budget.findRateOfReturn(totalPrize);
    }

    private int calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
    }

    public EnumMap<LottoRank, Integer> getRankCounts() {
        return this.rankCounts;
    }
}
