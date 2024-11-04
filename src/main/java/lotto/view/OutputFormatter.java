package lotto.view;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.LottoRank;

public class OutputFormatter {

    private static final String NEXT_LINE = System.lineSeparator();
    private static final String AMOUNT_QUANTITY_FORMAT = "%s%d개를 구매했습니다.";
    private static final String LOTTO_WINNING_RESULT_FORMAT = "%s - %d개";
    private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %,.1f%%입니다.";
    private static final long NO_LUCK_AMOUNT = 0L;

    public static String formatingQuantity(int quantity) {
        return String.format(AMOUNT_QUANTITY_FORMAT, NEXT_LINE, quantity);
    }

    public static String formatingWinningResult(Map<LottoRank, Integer> winningResult) {
        return formatResult(winningResult);
    }

    public static String formatingRateOfReturn(double rateOfReturn) {
        return String.format(RATE_OF_RETURN_FORMAT, rateOfReturn);
    }

    private static String formatResult(Map<LottoRank, Integer> winningResult) {
        return Arrays.stream(LottoRank.values())
                .filter(OutputFormatter::isWinningAmount)
                .map(lottoRank -> createFormat(winningResult, lottoRank))
                .collect(Collectors.joining(NEXT_LINE));
    }

    private static boolean isWinningAmount(LottoRank lottoRank) {
        return lottoRank.getWinningAmount() > NO_LUCK_AMOUNT;
    }

    private static String createFormat(Map<LottoRank, Integer> winningResult, LottoRank lottoRank) {
        String lottoDescription = lottoRank.getDescription();
        Integer lottoWinningCount = getLottoWinningCount(winningResult, lottoRank);

        return String.format(LOTTO_WINNING_RESULT_FORMAT, lottoDescription, lottoWinningCount);
    }

    private static Integer getLottoWinningCount(Map<LottoRank, Integer> winningResult, LottoRank lottoRank) {
        return winningResult.getOrDefault(lottoRank, 0);
    }
}
