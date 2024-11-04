package lotto.view;

import lotto.model.LottoStatistics;
import lotto.view.formatter.LottoStatisticsFormatter;

public class LottoStatisticsView {

    private static final LottoStatisticsFormatter LOTTO_STATISTICS_FORMATTER = new LottoStatisticsFormatter();;

    public LottoStatisticsView() {
    }

    public static void announceStatistics(LottoStatistics statistics) {
        String formattedStatistics = LottoStatisticsView.LOTTO_STATISTICS_FORMATTER.formatStatistics(statistics);

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(formattedStatistics);
        System.out.print("\n");
    }
}
