package lotto.view;

import lotto.model.lotto.Lottos;
import lotto.model.rank.Rank;
import lotto.model.rank.RankResult;

public class OutputView {

    private static final String NUMBER_OF_PURCHASES_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계";
    private static final String BREAK_LINE = "---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final int MIN_MATCHING_COUNT_FOR_OUTPUT = 3;
    private static final String RANK_DETAIL_FORMAT = "%d개 일치%s (%s원) - %d개\n";
    private static final String BONUS_MESSAGE = ", 보너스 볼 일치";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public static void printLottos(int count, Lottos lottos) {
        System.out.println(System.lineSeparator() + count + NUMBER_OF_PURCHASES_MESSAGE);
        printLottoNumbers(lottos);
    }

    private static void printLottoNumbers(Lottos lottos) {
        StringBuilder sb = new StringBuilder();
        lottos.getLottos().forEach(lotto -> sb.append(lotto).append(System.lineSeparator()));
        System.out.print(sb);
    }

    public static void printRankResult(RankResult result) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(BREAK_LINE);
        printRankDetails(result);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        double roundedRateOfReturn = Math.round(rateOfReturn * 10) / 10.0;
        System.out.printf(RATE_OF_RETURN_MESSAGE, roundedRateOfReturn);
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }

    private static void printRankDetails(RankResult result) {
        for (Rank rank : Rank.values()) {
            printRankIfEligible(result, rank);
        }
    }

    private static void printRankIfEligible(RankResult result, Rank rank) {
        int count = result.getRankCounts().getOrDefault(rank, 0);
        if (rank.getMatchingCount() >= MIN_MATCHING_COUNT_FOR_OUTPUT) {
            printRankDetail(rank, count);
        }
    }

    private static void printRankDetail(Rank rank, int count) {
        String bonusMessage = getBonusMessage(rank);
        System.out.printf(
                RANK_DETAIL_FORMAT,
                rank.getMatchingCount(),
                bonusMessage,
                String.format("%,d", rank.getPrize()),
                count
        );
    }

    private static String getBonusMessage(Rank rank) {
        if (rank.isHasBonus()) {
            return BONUS_MESSAGE;
        }
        return "";
    }

}
