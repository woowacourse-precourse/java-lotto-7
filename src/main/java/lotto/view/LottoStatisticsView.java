package lotto.view;

import java.text.NumberFormat;
import java.util.Map;
import lotto.helper.LottoStatisticsFormatHelper;
import lotto.model.LottoStatistics;
import lotto.model.constant.LottoRank;

public class LottoStatisticsView {

    private static final Map<LottoRank, RankCondition> RANK_MAP = Map.of(
            LottoRank.FIRST, new RankCondition(6, false),
            LottoRank.SECOND, new RankCondition(5, true),
            LottoRank.THIRD, new RankCondition(5, false),
            LottoRank.FOURTH, new RankCondition(4, false),
            LottoRank.FIFTH, new RankCondition(3, false)
    );

    private static final LottoStatisticsFormatHelper lottoStatisticsFormatHelper = new LottoStatisticsFormatHelper();

    public static void announceStatistics(LottoStatistics statistics) {
        Map<LottoRank, Integer> matchedByRank = statistics.getMatchedByRank();
        double percentRateOfReturn = statistics.getPercentRateOfReturn();

        System.out.println("당첨 통계");
        System.out.println("---");
        announceOfRank(LottoRank.FIFTH, matchedByRank);
        announceOfRank(LottoRank.FOURTH, matchedByRank);
        announceOfRank(LottoRank.THIRD, matchedByRank);
        announceOfRank(LottoRank.SECOND, matchedByRank);
        announceOfRank(LottoRank.FIRST, matchedByRank);
        announcePercentRateOfReturn(percentRateOfReturn);

        System.out.print("\n");
    }

    private static void announceOfRank(LottoRank rank, Map<LottoRank, Integer> matchedByRank) {
        String matchedFormat = "개 일치";
        if (RANK_MAP.get(rank).bonusMatch) {
            matchedFormat += ", 보너스 볼 일치";
        }

        System.out.printf(
                "%d" + matchedFormat + " (%s원) - %d개",
                RANK_MAP.get(rank).matchCount,
                NumberFormat.getInstance().format(rank.getWinningPrize()),
                matchedByRank.getOrDefault(rank, 0)
        );

        System.out.print("\n");
    }

    private static void announcePercentRateOfReturn(double percentRateOfReturn) {
        String formattedPercentRateOfReturn =
                lottoStatisticsFormatHelper.formatPercentRateOfReturn(percentRateOfReturn);
        System.out.println("총 수익률은 " + formattedPercentRateOfReturn + "%입니다.");
    }

    private record RankCondition(int matchCount, boolean bonusMatch) {
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof RankCondition that)) {
                return false;
            }
            return matchCount == that.matchCount && bonusMatch == that.bonusMatch;
        }
    }
}
