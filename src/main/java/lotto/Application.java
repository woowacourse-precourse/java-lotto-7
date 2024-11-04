package lotto;

import lotto.analytics.AnalyticsManager;
import lotto.purchase.LottoCreationManager;
import lotto.statistics.LottoStatisticsManager;

public class Application {
    public static void main(String[] args) {
        new EntireSystem(
                new LottoCreationManager(),
                new LottoStatisticsManager(),
                new AnalyticsManager()
        ).run();
    }
}
