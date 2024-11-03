package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.constants.Prizes;
import lotto.domain.LottoResult;
import lotto.vo.Money;

public class MarginCalculator {
    private final LottoResult lottoResult;
    private final Money userMoney;

    public MarginCalculator(LottoResult lottoResult, Money userMoney) {
        this.lottoResult = lottoResult;
        this.userMoney = userMoney;
    }

    public BigDecimal calculateMargin() {
        int profit = calculateProfit();
        BigDecimal userMoneyForCalculate = new BigDecimal(userMoney.money());
        BigDecimal profitForCalculate = new BigDecimal(profit);
        BigDecimal percentUnit = new BigDecimal("100.0");

        // 해당 반올림 방식은 Banker's rounding 이 아님.
        BigDecimal calculatedProfit = profitForCalculate
                .divide(userMoneyForCalculate)
                .multiply(percentUnit);

        return calculatedProfit.setScale(1, RoundingMode.HALF_UP);
    }

    private int calculateProfit() {
        int profit = 0;

        for (String prizeName : lottoResult.getResult().keySet()) {
            int prizeMoney = Prizes.valueOf(prizeName).getMoney();
            profit += prizeMoney * lottoResult.getResult().get(prizeName);
        }

        return profit;
    }
}
