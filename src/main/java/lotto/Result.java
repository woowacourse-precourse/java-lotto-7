package lotto;

import java.util.Map;

public class Result {

    private static final double ONE_THOUSAND = 1000;
    private static final double TEN = 10;

    private final Map<Rank, Integer> winningDetails;
    private final double rateOfReturn;

    public Result(Map<Rank, Integer> winningDetails, long lottoCount) {
        this.winningDetails = winningDetails;
        this.rateOfReturn = calculateRateOfReturn(winningDetails, lottoCount);
    }

    private double calculateRateOfReturn(Map<Rank, Integer> winningDetails, long lottoCount) {
        long prize = 0;
        for (Rank rank : winningDetails.keySet()) {
            prize += winningDetails.get(rank) * rank.getPrize();
        }

        return Math.round((double) prize / (lottoCount * LottoConstant.PRICE) * ONE_THOUSAND) / TEN;
    }

    public Map<Rank, Integer> getWinningDetails() {
        return winningDetails;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
