package lotto.model.result;

import java.util.EnumMap;
import java.util.Map.Entry;
import lotto.enums.LottoWinInfo;

public class Profit {
    private final double profit;

    public Profit(EnumMap<LottoWinInfo, Integer> lottoWinCount, int payment) {
        int totalPrize = calculateTotalPrize(lottoWinCount);
        profit = (double) totalPrize / payment * 100;
    }

    private int calculateTotalPrize(EnumMap<LottoWinInfo, Integer> lottoWinCount) {
        int totalPrize = 0;
        for (Entry<LottoWinInfo, Integer> lottoWinInfo : lottoWinCount.entrySet()) {
            int count = lottoWinInfo.getValue();
            int prize = lottoWinInfo.getKey().getPrize();
            totalPrize += count * prize;
        }
        return totalPrize;
    }

    public double getProfit() {
        return profit;
    }
}
