package lotto.view;

import lotto.constants.Ranking;

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
    private static final String WIN_ALARM_MESSAGE = NEXT_LINE + "당첨 통계" + NEXT_LINE + "---";
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 {0}%입니다.";

    public static void printLottoTicketInformation(List<List<Integer>> lottos, int lottoCount) {
        System.out.println(MessageFormat.format(BUY_LOTTO_COUNT_MESSAGE, lottoCount));
        lottos.forEach(numbers -> System.out.println(formatLottoNumbers(numbers)));
        System.out.print(NEXT_LINE);
    }

    public static void printWinStatistics(Map<Ranking, Integer> results) {
        System.out.println(WIN_ALARM_MESSAGE);
        System.out.println(formatRank(Ranking.FIFTH, getCountOrDefault(Ranking.FIFTH, results)));
        System.out.println(formatRank(Ranking.FOURTH, getCountOrDefault(Ranking.FOURTH, results)));
        System.out.println(formatRank(Ranking.THIRD, getCountOrDefault(Ranking.THIRD, results)));
        System.out.println(formatRank(Ranking.SECOND, getCountOrDefault(Ranking.SECOND, results)));
        System.out.println(formatRank(Ranking.FIRST, getCountOrDefault(Ranking.FIRST, results)));
    }

    private static String formatRank(Ranking rank, int count) {
        return MessageFormat.format(WIN_INFORMATION_MESSAGE, rank.getMatchCount(), rank.getReward(), count);
    }

    private static int getCountOrDefault(Ranking ranking, Map<Ranking, Integer> results) {
        return results.getOrDefault(ranking, 0);
    }

    private static String formatLottoNumbers(List<Integer> numbers) {
        return MessageFormat.format(LOTTO_FRAME, numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER_NUMBER)));
    }
}
