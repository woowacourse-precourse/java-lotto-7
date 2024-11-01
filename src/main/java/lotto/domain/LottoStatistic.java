package lotto.domain;

import static lotto.util.LottoConfig.LOTTO_PRICE;

public class LottoStatistic {
    private static final int PERCENT_CALCULATE = 100;
    private int totalPrize;
    private final double lottoStatistics;
    private final int[] lottoRanking;
    public LottoStatistic(LottoRanking lottoRanking, int quantity){
        this.lottoRanking = lottoRanking.getLottoRank();
        int totalAmount = quantity * LOTTO_PRICE.getNumber();
        getTotalPrize();
        lottoStatistics = (double) totalPrize*PERCENT_CALCULATE / totalAmount;
    }
    public void getTotalPrize() {
        for (Ranking rank : Ranking.values()) {
            totalPrize += rank.getPrize() * lottoRanking[rank.getIndex()];
        }
    }
    public double getLottoStatistics() {
        return Math.round(lottoStatistics*10)/10.0;
    }
}
