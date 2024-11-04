package lotto.model;

import static lotto.constants.Constants.*;

// 당첨 결과를 기록하고 수익률을 계산
public class ResultCalculator {
    private static final int[] PRIZE = {
            NOTHING_PLACE_PRIZE.getValue(),
            FIRST_PLACE_PRIZE.getValue(),
            SECOND_PLACE_PRIZE.getValue(),
            THIRD_PLACE_PRIZE.getValue(),
            FOURTH_PLACE_PRIZE.getValue(),
            FIFTH_PLACE_PRIZE.getValue()
    };
    private int[] rankCount = new int[6];
    private int totalPrize = 0;

    public void recordRank(int rank) {
        // rank는 등수를 뜻한다. 1등 = 1, 2등 = 2, 3등 = 3, 4등 = 4, 5등 = 5
        if (rank > 0 && rank <= 5) {
            rankCount[rank]++;
            totalPrize += PRIZE[rank];
        }
    }

    public double calculateProfitRate(int totalSpent) {
        return (double) totalPrize / totalSpent * PERCENTAGE_NUMBER.getValue();
    }

    public int[] getRankCount() {
        return rankCount;
    }

}
