package model;

import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoResult {
    private final List<Prize> winningResult;

    public LottoResult(List<Prize> winningResult) {
        this.winningResult = winningResult;
    }

    public List<Prize> getWinningResult() {
        return winningResult;
    }

    public double calculateWinningRate() {
        double cost = (double) this.winningResult.size() * 1000;
        double winningCost = 0.0;

        for (Prize prize : this.winningResult) {
            winningCost += prize.getPrizeMoney();
        }

        BigDecimal roundedWinningCost = new BigDecimal(winningCost / cost).setScale(2, RoundingMode.HALF_UP);
        return roundedWinningCost.doubleValue();

    }
}
