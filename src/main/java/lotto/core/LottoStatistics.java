package lotto.core;

import java.util.List;

public class LottoStatistics {
    private static final int FIRST_PRIZE = 2000000000;
    private static final int SECOND_PRIZE = 30000000;
    private static final int THIRD_PRIZE = 1500000;
    private static final int FOURTH_PRIZE = 50000;
    private static final int FIFTH_PRIZE = 5000;

    private final List<LottoResult> results;
    private final int purchaseAmount;

    public LottoStatistics(List<LottoResult> results, int purchaseAmount) {
        this.results = results;
        this.purchaseAmount = purchaseAmount;
    }

    public double calculateTotalEarnings() {
        int totalEarnings = 0;
        for (LottoResult result : results) {
            if (result.getMatchCount() == 6) {
                totalEarnings += FIRST_PRIZE;
            } else if (result.getMatchCount() == 5 && result.isMatch()) {
                totalEarnings += SECOND_PRIZE;
            } else if (result.getMatchCount() == 5) {
                totalEarnings += THIRD_PRIZE;
            } else if (result.getMatchCount() == 4) {
                totalEarnings += FOURTH_PRIZE;
            } else if (result.getMatchCount() == 3) {
                totalEarnings += FIFTH_PRIZE;
            }
        }
        return totalEarnings;
    }

    public double calculateProfitRate() {
        double totalEarnings = calculateTotalEarnings();
        return totalEarnings / purchaseAmount * 100; // 수익률 계산
    }
}
