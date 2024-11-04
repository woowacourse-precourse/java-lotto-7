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
    private static final String PRINT_FORMAT_WINNING_STATISTICS_MESSAGE = "%s개 일치%s (%s원) - %d개\n";
    private static final String PRINT_BONUS_NUMBER_MATCHING_MESSAGE = ", 보너스 볼 일치";
    private static final String FORMATTER_PATTERN = "###,###";
    private static final String PRINT_FORMAT_RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private static final int DEFAULT_COUNT_ZERO = 0;
    private static final int PERCENT_MAKER_NUMBER = 100;

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
        for (Ranking ranking : Ranking.winnerValuesOrderByRankDesc()) {
            String bonusNumberMatchingMessage = "";
            if (ranking.isBonusNumberMatching()) {
                bonusNumberMatchingMessage = PRINT_BONUS_NUMBER_MATCHING_MESSAGE;
            }
            System.out.printf(
                    PRINT_FORMAT_WINNING_STATISTICS_MESSAGE,
                    ranking.getMatchingCount(),
                    bonusNumberMatchingMessage,
                    formatter.format(ranking.getPrice()),
                    rankingCountMap.getOrDefault(ranking, DEFAULT_COUNT_ZERO)
            );
        }
    }

    public static void printRateOfReturn(int purchaseAmount, HashMap<Ranking, Integer> rankingCountMap) {
        long totalPrizeMoney = 0;
        for (Ranking ranking : Ranking.winnerValuesOrderByRankDesc()) {
            totalPrizeMoney += (long) ranking.getPrice() * rankingCountMap.getOrDefault(ranking, DEFAULT_COUNT_ZERO);
        }

        System.out.printf(PRINT_FORMAT_RATE_OF_RETURN_MESSAGE, ((double) totalPrizeMoney * PERCENT_MAKER_NUMBER) / purchaseAmount);
    }
}
