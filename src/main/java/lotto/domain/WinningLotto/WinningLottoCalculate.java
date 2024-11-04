package lotto.domain.WinningLotto;

import lotto.exception.ExceptionMessages;
import lotto.formatter.LottoFormatter;

import java.util.Map;

public class WinningLottoCalculate {
    private static final int LOTTO_PRICE = 1000;
    private static final double PERCENTAGE_MULTIPLIER = 100.0;

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
        validateBuyAmount(buyLottoMoney);
        int lottoCount = buyLottoMoney / LOTTO_PRICE;
        return lottoCount;
    }

    private long calculateTotalPrize() {
        Map<WinningLotto, Integer> counts = winningLottoCounter.getCounts();
        long sum = 0;
        for (Map.Entry<WinningLotto, Integer> entry : counts.entrySet()) {
            sum += (long) entry.getValue() * entry.getKey().getPrize();
        }
        return sum;
    }

    private double calculateRateOfReturn(int buyLottoMoney, long totalPrize) {
        double rateOfReturn = ((double) totalPrize / buyLottoMoney) * PERCENTAGE_MULTIPLIER;
        return rateOfReturn;
    }

    private void validateBuyAmount(int buyLottoMoney) {
        if (buyLottoMoney % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessages.LOTTO_BUY_AMOUNT_UNIT_ERROR);
        }
    }
}
