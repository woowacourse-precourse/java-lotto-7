package lotto.view.output;

import java.math.BigDecimal;
import java.util.Map;
import lotto.domain.Rank;
import lotto.dto.WinningResultDto;
import lotto.util.Parse;

public class ResultView {

    public static void printResult(WinningResultDto winningResult) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("당첨 통계\n---\n")
                .append(RankCounts(winningResult.rankCounts()))
                .append(ProfitRate(winningResult.profitRate()));

        System.out.println(stringBuilder.toString());
    }

    private static String RankCounts(Map<Rank, Integer> rankCounts) {
        StringBuilder stringBuilder = new StringBuilder();

        rankCounts.forEach((rank, count) -> {
            if (rank == Rank.NO_MATCH) {
                return;
            }

            stringBuilder.append(rank.getMatchCount())
                    .append(String.format(" (%,d원) - ", rank.getPrize()))
                    .append(count).append("개\n");
        });

        return stringBuilder.toString();
    }

    private static String ProfitRate(BigDecimal profitRate) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n총 수익률은 ")
                .append(Parse.formatWithCommas(profitRate))
                .append("%입니다.");

        return stringBuilder.toString();
    }

}
