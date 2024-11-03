package lotto.view;

import lotto.constants.Ranking;
import lotto.constants.ViewMessage;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    private static final String NEXT_LINE = "\n";
    private static final String LOTTO_FRAME = "[{0}]";
    private static final String DELIMITER_NUMBER = ", ";
    private static final String pattern = "#,##0.0";

    private OutputView() {
    }

    public static void printLottoTicketInformation(final List<List<Integer>> lottos, final int lottoCount) {
        System.out.println(MessageFormat.format(ViewMessage.BUY_LOTTO_COUNT_MESSAGE.getMessage(), lottoCount));
        lottos.forEach(numbers -> System.out.println(formatLottoNumbers(numbers)));
        System.out.print(NEXT_LINE);
    }

    public static void printWinStatistics(final double profit, final Map<Ranking, Integer> results) {
        System.out.println(ViewMessage.WIN_ALARM_MESSAGE.getMessage());
        Stream.of(Ranking.FIFTH, Ranking.FOURTH, Ranking.THIRD, Ranking.SECOND, Ranking.FIRST)
                .forEach(rank -> System.out.println(formatRank(rank, getCountOrDefault(rank, results))));
        System.out.println(MessageFormat.format(ViewMessage.TOTAL_PROFIT_MESSAGE.getMessage(), formatProfit(profit)));
    }

    private static String formatRank(final Ranking rank, final int count) {
        if (rank.isSecond()) {
            return MessageFormat.format(ViewMessage.WIN_SECOND_INFORMATION_MESSAGE.getMessage(), rank.getMatchCount(), rank.getReward(), count);
        }
        return MessageFormat.format(ViewMessage.WIN_INFORMATION_MESSAGE.getMessage(), rank.getMatchCount(), rank.getReward(), count);
    }

    private static int getCountOrDefault(final Ranking ranking, final Map<Ranking, Integer> results) {
        return results.getOrDefault(ranking, 0);
    }

    private static String formatProfit(double profit) {
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(profit);
    }

    private static String formatLottoNumbers(final List<Integer> numbers) {
        return MessageFormat.format(LOTTO_FRAME, numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER_NUMBER)));
    }
}