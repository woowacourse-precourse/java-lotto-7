package lotto.view;

import java.util.List;
import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class OutputView {
    private static final String LOTTO_BUY_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String RESULT_MESSAGE = "당첨 통계\n---";
    private static final String MATCH_COUNT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String MATCH_COUNT_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String WINNINGS_FORMAT = "%,d";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.%n";

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printLottos(List<Lotto> lottos) {
        printLottoBuyCount(lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printMatchCounts(LottoResult result) {
        String message;

        for (Rank rank : Rank.values()) {
            message = createRankMessage(rank, result.getWinningCount().get(rank));
            System.out.println(message);
        }
    }

    public static void printProfitRate(LottoResult result) {
        System.out.printf(PROFIT_RATE_MESSAGE, result.getProfitRate());
    }

    private static void printLottoBuyCount(int count) {
        String message = String.format(LOTTO_BUY_COUNT_MESSAGE, count);
        System.out.println(message);
    }

    private static String formatWinnings(long winnings) {
        return String.format(WINNINGS_FORMAT, winnings);
    }

    private static String createRankMessage(Rank rank, int matchCount) {
        if (rank == Rank.FIVE_MATCH_BONUS) {
            return String.format(
                    MATCH_COUNT_BONUS_MESSAGE,
                    rank.getMatchCount(),
                    formatWinnings(rank.getWinnings()),
                    matchCount);
        }
        return String.format(MATCH_COUNT_MESSAGE,
                rank.getMatchCount(),
                formatWinnings(rank.getWinnings()),
                matchCount);
    }
}
