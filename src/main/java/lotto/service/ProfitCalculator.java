package lotto.service;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningInfo;

import java.util.HashMap;
import java.util.Map;

public class ProfitCalculator {
    private final LottoResult lottoResult;
    private static final Integer PRICE_UNIT = 1000;
    private static final Integer PERCENT = 100;

    public ProfitCalculator(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }


    public Double getProfitRate(Lottos lottos) {
        int totalBenefit = calculateTotalBenefit();
        double profit = (double) (totalBenefit / lottos.getLottoCount()) / PRICE_UNIT * PERCENT;
        return Math.round(profit * 10.0) / 10.0;
    }

    private Integer calculateTotalBenefit() {
        int totalBenefit = 0;
        HashMap<WinningInfo, Integer> result = lottoResult.getResult();
        for (Map.Entry<WinningInfo, Integer> entry : result.entrySet()) {
            totalBenefit += entry.getKey().getWinningAmount() * entry.getValue();
        }
        return totalBenefit;
    }
}
