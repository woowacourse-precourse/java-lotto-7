package lotto.view.output;

import java.math.BigDecimal;
import java.util.Map;
import lotto.domain.Rank;
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

    private static String prizeCounts(Map<Rank, Integer> rankCounts) {
        StringBuilder stringBuilder = new StringBuilder();

        rankCounts.forEach((rank, count) -> {
            if (rank == Rank.NO_MATCH) {
                return;
            }

            // @todo 등수 여기서 출력
            stringBuilder.append(getDescription(rank))
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

    public static String getDescription(Rank rank) {
        if (rank == Rank.FIVE_MATCHES_WITH_BONUS) {
            return "5개 일치, 보너스 볼 일치";
        }
        return rank.getRequiredMatchCount() + "개 일치";
    }

}
