package lotto.model.outcome;

import lotto.model.PrizeGrade;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/** 로또 등급별 당첨 개수와 총 구매액을 통해 로또 수익률을 계산하고 보관하는 클래스 */
public class LottoBenefitRate {

    private final BigDecimal rate;

    private LottoBenefitRate(BigDecimal benefitRate) {
        this.rate = benefitRate;
    }

    // 당첨 결과와 구매액을 매개변수로 받아 수익률(당첨금 합/ 구매액 * 100) 객체 생성
    public static LottoBenefitRate getOfCountByGradeAndSpendMoney(CountByPrizeGrade countByGrade,
                                                                  long spendMoneyInput) {
        long totalPrizeMoney = 0L;
        for (Map.Entry<PrizeGrade, Integer> gradeByCount : countByGrade.getEntrySet()) {
            PrizeGrade grade = gradeByCount.getKey();
            int count = gradeByCount.getValue();
            totalPrizeMoney += grade.getMoney() * count;
        }

        BigDecimal prizeMoneySum = BigDecimal.valueOf(totalPrizeMoney);
        BigDecimal spendMoney = BigDecimal.valueOf(spendMoneyInput);
        BigDecimal hundred = BigDecimal.valueOf(100);
        prizeMoneySum = prizeMoneySum.multiply(hundred);
        BigDecimal rate = prizeMoneySum.divide(spendMoney, 1, RoundingMode.HALF_UP);

        return new LottoBenefitRate(rate);
    }

    @Override
    public String toString() {
        return rate.toString();
    }

}
