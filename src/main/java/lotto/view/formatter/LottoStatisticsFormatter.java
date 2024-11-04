package lotto.view.formatter;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.model.LottoStatistics;
import lotto.model.constant.LottoRank;

public class LottoStatisticsFormatter {

    private static final Map<LottoRank, RankCondition> CONDITION_OF_RANK = Map.of(
            LottoRank.FIRST, new RankCondition(6, false),
            LottoRank.SECOND, new RankCondition(5, true),
            LottoRank.THIRD, new RankCondition(5, false),
            LottoRank.FOURTH, new RankCondition(4, false),
            LottoRank.FIFTH, new RankCondition(3, false)
    );

    public String formatStatistics(LottoStatistics statistics) {
        return formatPerRank(statistics, LottoRank.FIRST) + "\n"
                + formatPerRank(statistics, LottoRank.SECOND) + "\n"
                + formatPerRank(statistics, LottoRank.THIRD) + "\n"
                + formatPerRank(statistics, LottoRank.FOURTH) + "\n"
                + formatPerRank(statistics, LottoRank.FIFTH) + "\n"
                + formatPercentRateOfReturn(statistics) + "\n";
    }

    private String formatPerRank(LottoStatistics statistics, LottoRank rank) {
        RankCondition rankCondition = CONDITION_OF_RANK.get(rank);

        String matchedFormat = "개 일치";
        if (rankCondition.bonusMatch) {
            matchedFormat += ", 보너스 볼 일치";
        }

        int matchCount = rankCondition.matchCount;
        int winningPrize = rank.getWinningPrize();
        int matchedCount = statistics.getMatchedByRank().getOrDefault(rank, 0);

        return String.format("%s" + matchedFormat + " (%s원) - %s개",
                formatThousandsSeparator(matchCount),
                formatThousandsSeparator(winningPrize),
                formatThousandsSeparator(matchedCount));
    }

    private String formatThousandsSeparator(int winningPrize) {
        DecimalFormat winningPrizeFormat = new DecimalFormat("###,###");
        return winningPrizeFormat.format(winningPrize);
    }

    private String formatPercentRateOfReturn(LottoStatistics statistics) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");

        double percentRateOfReturn = Math.round(statistics.getPercentRateOfReturn() * 100.0) / 100.0;
        String formattedPercentRateOfReturn = decimalFormat.format(percentRateOfReturn);

        return "총 수익률은 " + formattedPercentRateOfReturn + "%입니다.";
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
