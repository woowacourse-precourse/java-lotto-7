package lotto.service;

import static lotto.constants.Constants.INITIAL_PROFIT;
import static lotto.constants.Constants.PERCENT_UNIT;

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
        BigDecimal percentUnit = new BigDecimal(Integer.toString(PERCENT_UNIT));

        BigDecimal calculatedPercentage = calculatePercentage(userMoneyForCalculate, profitForCalculate, percentUnit);
        // 해당 반올림 방식은 Banker's rounding 이 아님.
        return calculatedPercentage.setScale(1, RoundingMode.HALF_UP);
    }

    private BigDecimal calculatePercentage(BigDecimal userMoneyForCalculate, BigDecimal profitForCalculate,
                                           BigDecimal percentUnit) {

        return profitForCalculate
                .divide(userMoneyForCalculate)
                .multiply(percentUnit);
    }

    private int calculateProfit() {
        int profit = INITIAL_PROFIT;

        for (String prizeName : lottoResult.getResult().keySet()) {
            int prizeMoney = Prizes.valueOf(prizeName).getMoney();
            profit += prizeMoney * lottoResult.getResult().get(prizeName);
        }

        return profit;
    }
}
