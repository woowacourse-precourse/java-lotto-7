package lotto.service.domain.statistics;

import java.util.List;
import java.util.Map;
import lotto.service.domain.money.Money;

public class StatisticsReport { // 책임: 통계를 넘겨 준다. 이걸로 출력에 관한 클래스가 출력한다.
    private Map<Integer, Integer> winCount;
    private double profitRate;

    public StatisticsReport(Map<Integer, Integer> winCount, double profitRate) {
        this.winCount = winCount;
        this.profitRate = profitRate;
    }

    public Map<Integer, Integer> getWinCount() {
        return winCount;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
