package lotto.lotto;

import java.util.List;

public class Analyst {

    private final StringBuilder statistics = new StringBuilder();
    private final List<Prize> prizes;


    public Analyst(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public String getStatistics() {
        for (Prize criteria : Prize.values()) {
            int count = (int) prizes.stream()
                    .filter(prize -> prize.equals(criteria))
                    .count();
            setStatisticsInfo(criteria, statistics, count);
        }
        return statistics.toString();
    }

    private void setStatisticsInfo(Prize criteria, StringBuilder statistics, int count) {
        statistics.append(criteria.getCount())
                .append("개 일치 ");

        if (criteria.equals(Prize.SECOND)) {
            statistics.append(", 보너스 볼 일치");
        }
        statistics.append("(" + criteria.getMoney().toString() + "원)")
                .append(" - " + count + "개")
                .append("\n");
    }
}
