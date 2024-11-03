package lotto.view;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Ranking;

public class OutputView {

    private static final String PRINT_PURCHASED_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String PRINT_WINNING_STATISTICS_MESSAGE = "당첨 통계.";
    private static final String PRINT_SEPARATOR_LINE = "---";
    private static final String PRINT_FORMAT_WINNING_STATISTICS_MESSAGE = "%s개 일치 (%s원) - %d개\n";
    private static final String FORMATTER_PATTERN = "###,###";

    private static final int DEFAULT_COUNT_ZERO = 0;

    public static void printPurchasedLottoCountAndNumber(List<Lotto> lottos) {
        System.out.println(lottos.size() + PRINT_PURCHASED_LOTTO_COUNT_MESSAGE);
        lottos.forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers().stream().sorted(Integer::compareTo).toList();
            System.out.println(numbers);
        });
    }

    public static void printWinningHistory(HashMap<Ranking, Integer> rankingCountMap) {
        DecimalFormat formatter = new DecimalFormat(FORMATTER_PATTERN);

        System.out.println(PRINT_WINNING_STATISTICS_MESSAGE);
        System.out.println(PRINT_SEPARATOR_LINE);
        Ranking.valuesOrderByRankDesc().forEach(
                ranking -> System.out.printf
                        (
                                PRINT_FORMAT_WINNING_STATISTICS_MESSAGE,
                                ranking.getMatchingCount(),
                                formatter.format(ranking.getPrice()),
                                rankingCountMap.getOrDefault(ranking, DEFAULT_COUNT_ZERO)
                        )
        );
    }
}
