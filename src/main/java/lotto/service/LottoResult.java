package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;

public class LottoResult {

    private static final int ROUNDING_SCALE = 10;
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String STATISTICS_HEADER = "\n당첨 통계\n---";

    private void recordMatchResult(int matchCount, boolean matchBonus) {
        Rank rank = Rank.getRank(matchCount, matchBonus);
        rank.increaseCount();
    }

    public void evaluateLottoResults(LottoTicket lottoTicket, LottoNumbers lottoNumbers) {
        for (Lotto lotto : lottoTicket.getLottos()) {
            int mathCount = lottoNumbers.countMatchingNumbers(lotto);
            boolean matchBonus = lottoNumbers.isBonusMatched(lotto);
            recordMatchResult(mathCount, matchBonus);
        }
    }

    public double calculateRateOfReturn(PurchaseAmount purchaseAmount) {
        int totalPrize = calculateTotalPrize();
        double rateOfReturn = ((double) totalPrize / purchaseAmount.getAmount()) * 100;
        return Math.round(rateOfReturn * ROUNDING_SCALE) / (double) ROUNDING_SCALE;
    }

    private int calculateTotalPrize() {
        int total = 0;
        for (Rank rank : Rank.values()) {
            total += rank.getCount() * rank.getPrize();
        }
        return total;
    }

    public void displayRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }

    public void displayWinningStatistics() {
        System.out.println(STATISTICS_HEADER);
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.println(rank);
            }
        }
    }
}

