package lotto.Controller;

import lotto.Enum.WinningPrize;
import lotto.View.OutputEarningRateView;

import java.util.Map;

public class EarningRateController {
    private Map<String, Integer> resultMap;

    public void earningRate(int price, Map<String, Integer> resultMap) {
        OutputEarningRateView outputEarningRateView = new OutputEarningRateView();
        double earningRate = calculateEarningRate(price, resultMap);
        outputEarningRateView.printEarningRate(earningRate);
    }

    public double calculateEarningRate(int price, Map<String, Integer> resultMap) {
        this.resultMap = resultMap;
        long total = totalEarning();

        return (double) total / price * 100;
    }

    private Long totalEarning() {
        long total = 0L;
        for (WinningPrize winningPrize : WinningPrize.values()) {
            total += resultMap.get(winningPrize.toString()) * winningPrize.getPrizeMoney();
        }

        return total;
    }

}
