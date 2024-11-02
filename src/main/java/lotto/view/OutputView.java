package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.service.PrizeCalculator;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String ISSUED_LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.%n";
    private static final String RESULT_STATISTICS_TITLE = "당첨 통계";
    private static final String DIVIDER = "---";
    private static final String MATCH_RESULT_FORMAT = "%d개 일치 (%s원) - %d개%n";
    private static final String MATCH_RESULT_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원) - %d개%n";
    private static final String PROFIT_FORMAT = "총 수익률은 %.1f%%입니다.";

    public static void printIssuedLottos(List<Lotto> issuedLottos) {
        System.out.print(NEW_LINE);
        System.out.printf(ISSUED_LOTTO_COUNT_FORMAT, issuedLottos.size());
        issuedLottos.forEach(lotto -> {
            System.out.println("[" + lotto.getNumbers() + "]");
        });
    }

    public static void printPrizeCounts(Map<Integer, Integer> prizeCounts) {
        System.out.print(NEW_LINE);
        System.out.println(RESULT_STATISTICS_TITLE);
        System.out.println(DIVIDER);

        printRank(3, PrizeCalculator.getPrizeAmount(5), prizeCounts.getOrDefault(5, 0));
        printRank(4, PrizeCalculator.getPrizeAmount(4), prizeCounts.getOrDefault(4, 0));
        printRank(5, PrizeCalculator.getPrizeAmount(3), prizeCounts.getOrDefault(3, 0));
        printBonusRank(5, PrizeCalculator.getPrizeAmount(2), prizeCounts.getOrDefault(2, 0));
        printRank(6, PrizeCalculator.getPrizeAmount(1), prizeCounts.getOrDefault(1, 0));
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_FORMAT, profitRate);
    }

    private static void printRank(int matchCount, int prizeAmount, int count) {
        System.out.printf(MATCH_RESULT_FORMAT, matchCount, prizeAmount, count);
    }

    private static void printBonusRank(int matchCount, int prizeAmount, int count) {
        System.out.printf(MATCH_RESULT_BONUS_FORMAT, matchCount, prizeAmount, count);
    }
}
