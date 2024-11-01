package lotto.view;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Rank;
import lotto.domain.lottos.user.WinningLotto;

public class WinningStatisticsPrinter {
    private final static String PRINT_RANK_FORMAT = "%d개 일치 (%s원) - %d개\n";
    private final static String PRINT_SECOND_RANK_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private final static String PRIZE_MONEY_FORMAT = "%,d";

    public static void print(WinningLotto winningLotto) {
        System.out.print(getPrintout(winningLotto));
    }

    public static String getPrintout(WinningLotto winningLotto) {
        StringBuilder printout = new StringBuilder();
        EnumMap<Rank, Integer> ranks = winningLotto.getWinningStatistics();
        loopScore(printout, ranks);

        return printout.toString();
    }

    private static void loopScore(StringBuilder printout, Map<Rank, Integer> ranks) {
        for (Map.Entry<Rank, Integer> entry : ranks.entrySet()) {
            Rank rank = entry.getKey();

            if (rank.equals(Rank.NOTHING)) {
                continue;
            }
            printout.append(getFormattedScorePrintout(entry, rank));
        }
    }

    private static String getFormattedScorePrintout(Entry<Rank, Integer> entry, Rank rank) {
        int matchCount = rank.getMatchCount();
        String formatedPrizedMoney = String.format(PRIZE_MONEY_FORMAT, rank.getPrizeMoney());
        int matchResult = entry.getValue();

        if (rank.equals(Rank.SECOND)) {
            return String.format(PRINT_SECOND_RANK_FORMAT, matchCount, formatedPrizedMoney, matchResult);
        }
        return String.format(PRINT_RANK_FORMAT, matchCount, formatedPrizedMoney, matchResult);
    }

}
