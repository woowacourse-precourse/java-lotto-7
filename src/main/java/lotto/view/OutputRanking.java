package lotto.view;

import lotto.domain.Rank;
import lotto.service.RankService;
import java.text.DecimalFormat;

public class OutputRanking {

    private static final String MESSAGE_STATISTICS = "\n당첨 통계";
    private static final String LINES = "---";
    private static final String MESSAGE_RANK = "%d개 일치 (%,d원) - %d개";
    private static final String MESSAGE_RANK_SECOND = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";

    public static void rankingOutput(RankService ranking) {
        System.out.println(MESSAGE_STATISTICS);
        System.out.println(LINES);
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NOTHING) {
                continue;
            }
            System.out.println(rankResult(rank, ranking));
        }
    }

    private static String rankResult(Rank rank, RankService ranking) {
        if (rank == Rank.SECOND) {
            return String.format(MESSAGE_RANK_SECOND,
                    rank.getRankWinning(),
                    rank.getRankMoney(),
                    ranking.rankCount(rank));
        }
        return String.format(MESSAGE_RANK,
                rank.getRankWinning(),
                rank.getRankMoney(),
                ranking.rankCount(rank));
    }

}
