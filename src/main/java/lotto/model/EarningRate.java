package lotto.model;

import java.util.List;

public class EarningRate {
    private double earningRate;

    public EarningRate(List<Integer> lottoWinningCounts, Amount amount) {
        calculateEarningRate(lottoWinningCounts, amount);
    }

    public void calculateEarningRate(List<Integer> lottoWinningCounts, Amount amount){
        LottoRank[] ranks = LottoRank.values();
        int totalEarning = 0;

        for (int i = 0; i < ranks.length ; i++) {
            totalEarning = totalEarning + (ranks[i].getPrize() * lottoWinningCounts.get(i));
        }

        double earningRate = ((double) totalEarning / amount.getAmount()) * 100.00;
        this.earningRate = Math.round(earningRate*10.0)/10.0; //소수점 둘째 자리에서 반올림 저장
    }

    public double getEarningRate() {
        return earningRate;
    }
}
