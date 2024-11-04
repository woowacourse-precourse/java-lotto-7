package lotto.view.output;

import java.math.BigDecimal;
import java.util.Map;
import lotto.domain.Prize;
import lotto.dto.WinningResultDto;
import lotto.util.Parse;

public class ResultView {

    public static void printResult(WinningResultDto winningResult) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n당첨 통계\n---\n")
                .append(prizeCounts(winningResult.rankCounts()))
                .append(profitRate(winningResult.profitRate()));

        System.out.println(stringBuilder.toString());
    }

    private static String prizeCounts(Map<Prize, Integer> rankCounts) {
        StringBuilder stringBuilder = new StringBuilder();

        rankCounts.forEach((rank, count) -> {
            if (rank == Prize.NO_MATCH) {
                return;
            }

            stringBuilder.append(rank.getMatchDescription())
                    .append(String.format(" (%,d원) - ", rank.getPrize()))
                    .append(count).append("개\n");
        });

        return stringBuilder.toString();
    }

    private static String profitRate(BigDecimal profitRate) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n총 수익률은 ")
                .append(Parse.formatWithCommas(profitRate))
                .append("%입니다.");

        return stringBuilder.toString();
    }

}
