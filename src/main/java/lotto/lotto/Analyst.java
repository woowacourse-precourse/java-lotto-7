package lotto.lotto;

import lotto.lotto.value.Money;
import lotto.lotto.value.Prize;

import java.util.List;

public class Analyst {

    private final StringBuilder report = new StringBuilder();
    private final List<Prize> prizes;


    public Analyst(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public String announceResult(Money spentMoney) {
        for (Prize criteria : Prize.values()) {
            int count = (int) prizes.stream()
                    .filter(prize -> prize.equals(criteria))
                    .count();
            setStatisticsInfo(criteria, count);
        }
        setProfitsInfo(spentMoney);
        return report.toString();
    }

    private void setProfitsInfo(Money spentMoney) {
        int sum = prizes.stream()
                .map(Prize::getMoney)
                .mapToInt(Money::getValue)
                .sum();
        Money totalMoney = new Money(sum);

        double profits = spentMoney.getRateBy(totalMoney);
        report.append("총 수익률은 ")
                .append(profits)
                .append("%입니다.");

    }

    private void setStatisticsInfo(Prize criteria, int count) {
        if (criteria == Prize.NOTHING) {
            return;
        }
        report.append(criteria.getCount())
                .append("개 일치");

        if (criteria.equals(Prize.SECOND)) {
            report.append(", 보너스 볼 일치");
        }
        report.append(" (" + criteria.getMoney().toString() + "원)")
                .append(" - " + count + "개")
                .append("\n");
    }
}
