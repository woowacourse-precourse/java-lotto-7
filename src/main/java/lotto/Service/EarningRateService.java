package lotto.Service;

import lotto.Enum.WinningPrize;

import java.util.Map;

public class EarningRateService {
    private Map<String, Integer> resultMap;

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
