package lotto.io.printer.rank;

import java.util.Map;
import lotto.io.printer.StringPrinter;
import lotto.value.Rank;

public class ConsoleStatisticsPrinter implements StatisticsPrinter {

    private final StringPrinter stringPrinter;

    public ConsoleStatisticsPrinter(StringPrinter stringPrinter) {
        this.stringPrinter = stringPrinter;
    }

    @Override
    public void printRankStatistics(Map<Rank, Integer> rankMap) {
        String rankStatistics = rankStatisticsPrompt(
                Rank.FIFTH_PLACE, rankMap.getOrDefault(Rank.FIFTH_PLACE, 0)) + "\n"
                + rankStatisticsPrompt(
                Rank.FOURTH_PLACE, rankMap.getOrDefault(Rank.FOURTH_PLACE, 0)) + "\n"
                + rankStatisticsPrompt(
                Rank.THIRD_PLACE, rankMap.getOrDefault(Rank.THIRD_PLACE, 0)) + "\n"
                + rankStatisticsPrompt(
                Rank.SECOND_PLACE, rankMap.getOrDefault(Rank.SECOND_PLACE, 0)) + "\n"
                + rankStatisticsPrompt(
                Rank.FIRST_PLACE, rankMap.getOrDefault(Rank.FIRST_PLACE, 0));
        stringPrinter.printString(rankStatistics);
    }

    private String rankStatisticsPrompt(Rank rank, int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(rank.getMatchCount()).append("개 일치");
        if (rank.equals(Rank.SECOND_PLACE)) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (").append(rank.getPrizeWithDelimiter()).append("원)");
        sb.append(" - ").append(count).append("개");
        return sb.toString();
    }

}
