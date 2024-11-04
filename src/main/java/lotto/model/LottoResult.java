package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private final List<Lotto> lottoTickets;
    private final List<Integer> winLottoNumbers;
    private final Integer winBonusNumber;
    private final List<Integer> statistics;
    private final double profitRate;

    private static final int[] PRIZE_TABLE = {0, 0, 0, 5000, 50000, 1500000, 2000000000};
    private static final int BONUS_PRIZE = 30000000;

    public LottoResult(List<Lotto> lottoTickets, List<Integer> winLottoNumbers, Integer winBonusNumber) {
        this.lottoTickets = lottoTickets;
        this.winLottoNumbers = winLottoNumbers;
        this.winBonusNumber = winBonusNumber;
        this.statistics = new ArrayList<>(List.of(0, 0, 0, 0, 0)); // 3개, 4개, 5개, 5개+보너스, 6개 일치 개수

        calculateStatistics();
        this.profitRate = calculateProfitRate();
    }

    private void calculateStatistics() {
        for (Lotto lotto : lottoTickets) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winLottoNumbers::contains)
                    .count();
            boolean hasBonus = lotto.getNumbers().contains(winBonusNumber);

            if (matchCount == 3) {
                statistics.set(0, statistics.get(0) + 1);
            } else if (matchCount == 4) {
                statistics.set(1, statistics.get(1) + 1);
            } else if (matchCount == 5 && hasBonus) {
                statistics.set(3, statistics.get(3) + 1);
            } else if (matchCount == 5) {
                statistics.set(2, statistics.get(2) + 1);
            } else if (matchCount == 6) {
                statistics.set(4, statistics.get(4) + 1);
            }
        }
    }

    private double calculateProfitRate() {
        int totalPrize = 0;
        totalPrize += statistics.get(0) * PRIZE_TABLE[3]; // 3개 일치 상금
        totalPrize += statistics.get(1) * PRIZE_TABLE[4]; // 4개 일치 상금
        totalPrize += statistics.get(2) * PRIZE_TABLE[5]; // 5개 일치 상금
        totalPrize += statistics.get(3) * BONUS_PRIZE;    // 5개 일치 + 보너스 상금
        totalPrize += statistics.get(4) * PRIZE_TABLE[6]; // 6개 일치 상금

        int totalCost = lottoTickets.size() * 1000; // 1장당 1000원으로 가정
        return (double) totalPrize / totalCost * 100;
    }

    public List<Integer> getStatistics() {
        return statistics;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
