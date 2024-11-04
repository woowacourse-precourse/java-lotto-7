package lotto;

import java.util.Map;

public class Output {
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.%n";
    private static final String STATISTICS_HEADER = "\n당첨 통계\n---";
    private static final String MATCH_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개%n";
    private static final String MATCH_RESULT_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.%n";


    public static void printLottos(Lottos lottos) {
        System.out.printf(LOTTO_COUNT_MESSAGE, lottos.getCount());
        System.out.println(lottos);
    }

    public static void printResult(Map<Rank, Integer> statistics, double profitRate) {
        System.out.println(STATISTICS_HEADER);

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }

            int count = statistics.getOrDefault(rank, 0);
            if (rank.isBonusMatch()) {
                System.out.printf(MATCH_RESULT_BONUS_MESSAGE, rank.getMatchCount(), formatPrize(rank.getPrize()),
                        count);
            }
            System.out.printf(MATCH_RESULT_MESSAGE, rank.getMatchCount(), formatPrize(rank.getPrize()), count);

            System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
        }
    }

    private static String formatPrize(int prize) {
        return String.format("%,d", prize);
    }
}
