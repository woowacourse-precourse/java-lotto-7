package lotto;

import java.util.List;

public class StatisticsController {

    public LottoResult calculateWinnings(List<Lotto> lottos, WinNumbers winNumbers) {
        int totalWinnings = 0;
        int[] rankCount = new int[Rank.values().length];
        for (Lotto lotto : lottos) {
            Rank rank = lotto.matchWinNumbers(winNumbers.getWinNumbers(), winNumbers.getBonusNumber());
            rankCount[rank.ordinal()]++;
            totalWinnings += rank.getPrizeMoney();
        }
        return new LottoResult(totalWinnings, rankCount);
    }

    public double calculateRateOfReturn(int totalWinnings, int purchaseNumber) {
        double rateOfReturn = (double) totalWinnings / purchaseNumber;
        return Math.round(rateOfReturn) / 10.0;
    }
}
