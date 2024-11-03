package lotto.view;

import lotto.constants.Ranking;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NEXT_LINE = "\n";
    private static final String LOTTO_FRAME = "[{0}]";
    private static final String DELIMITER_NUMBER = ", ";
    private static final String BUY_LOTTO_COUNT_MESSAGE = NEXT_LINE + "{0}개를 구매했습니다.";
    private static final String WIN_INFORMATION_MESSAGE = "{0}개 일치 ({1}원) - {2}개";
    private static final String WIN_SECOND_INFORMATION_MESSAGE = "{0}개 일치, 보너스 볼 일치 ({1}원) - {2}개";
    private static final String WIN_ALARM_MESSAGE = NEXT_LINE + "당첨 통계" + NEXT_LINE + "---";
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 {0}%입니다.";
    private static final String pattern = "#,##0.0";

    private OutputView(){
    }

    public static void printLottoTicketInformation(final List<List<Integer>> lottos, final int lottoCount) {
        System.out.println(MessageFormat.format(BUY_LOTTO_COUNT_MESSAGE, lottoCount));
        lottos.forEach(numbers -> System.out.println(formatLottoNumbers(numbers)));
        System.out.print(NEXT_LINE);
    }

    public static void printWinStatistics(final double profit, final Map<Ranking, Integer> results) {
        System.out.println(WIN_ALARM_MESSAGE);
        System.out.println(formatRank(Ranking.FIFTH, getCountOrDefault(Ranking.FIFTH, results)));
        System.out.println(formatRank(Ranking.FOURTH, getCountOrDefault(Ranking.FOURTH, results)));
        System.out.println(formatRank(Ranking.THIRD, getCountOrDefault(Ranking.THIRD, results)));
        System.out.println(formatRank(Ranking.SECOND, getCountOrDefault(Ranking.SECOND, results)));
        System.out.println(formatRank(Ranking.FIRST, getCountOrDefault(Ranking.FIRST, results)));
        System.out.println(MessageFormat.format(TOTAL_PROFIT_MESSAGE, formatProfit(profit)));
    }

    private static String formatRank(final Ranking rank, final int count) {
        if (rank.isSecond()) {
            return MessageFormat.format(WIN_SECOND_INFORMATION_MESSAGE, rank.getMatchCount(), rank.getReward(), count);
        }
        return MessageFormat.format(WIN_INFORMATION_MESSAGE, rank.getMatchCount(), rank.getReward(), count);
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
