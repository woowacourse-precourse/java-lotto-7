package lotto.service.domain.statistics;

import java.util.List;
import java.util.Map;
import lotto.service.domain.lotto.LottoReward;
import lotto.service.domain.money.Money;

public class StatisticsReport { // 책임: 통계를 넘겨 준다. 이걸로 출력에 관한 클래스가 출력한다.
    private List<LottoReward> winReport;
    private double profitRate;

    public StatisticsReport(List<LottoReward> winReport, double profitRate) {
        this.winReport = winReport;
        this.profitRate = profitRate;
    }


}
