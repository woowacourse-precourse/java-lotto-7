package lotto.domain.WinningLotto;

import lotto.domain.LottoFormatter;

import java.util.Map;

public class WinningLottoCalculate {
    private final WinningLottoCounter winningLottoCounter;
    private final LottoFormatter lottoFormatter;

    public WinningLottoCalculate(WinningLottoCounter winningLottoCounter, LottoFormatter lottoFormatter) {
        this.winningLottoCounter = winningLottoCounter;
        this.lottoFormatter = lottoFormatter;
    }

    public double calculateLottoRateOfReturn(int buyLottoMoney) {
        long totalAmount = calculateTotalPrize();
        double rateOfReturn = calculateRateOfReturn(buyLottoMoney, totalAmount);
        return lottoFormatter.formatRounding(rateOfReturn);
    }

    public int calculateBuyLottoCount(int buyLottoMoney) {
        int lottoCount = buyLottoMoney / 1000;
        return lottoCount;
    }

    private long calculateTotalPrize() {
        Map<WinningLotto, Integer> counts = winningLottoCounter.getAllCounts();
        long sum = 0;
        for (Map.Entry<WinningLotto, Integer> entry : counts.entrySet()) {
            sum += (long) entry.getValue() * entry.getKey().getPrize();
        }
        return sum;
    }

    private double calculateRateOfReturn(int buyLottoMoney, long totalPrize) {
        double rateOfReturn = ((double) totalPrize / buyLottoMoney) * 100;
        return rateOfReturn;
    }
}
