package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import static lotto.constant.OutputMessages.LOTTO_BUY_COUNT_MESSAGE;
import static lotto.constant.OutputMessages.OUTPUT_DELIMITER;
import static lotto.constant.OutputMessages.PREFIX;
import static lotto.constant.OutputMessages.SUFFIX;
import static lotto.constant.OutputMessages.RESULT_MESSAGE;
import static lotto.constant.OutputMessages.MATCH_COUNT_MESSAGE;
import static lotto.constant.OutputMessages.MATCH_COUNT_BONUS_MESSAGE;
import static lotto.constant.OutputMessages.WINNINGS_FORMAT;
import static lotto.constant.OutputMessages.PROFIT_RATE_MESSAGE;

public class OutputView {
    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printLottos(List<Lotto> lottos) {
        printLottoBuyCount(lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(convertLottoToString(lotto));
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

    private static String convertLottoToString(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(OUTPUT_DELIMITER, PREFIX, SUFFIX));
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
