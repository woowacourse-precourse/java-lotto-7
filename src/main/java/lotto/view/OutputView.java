package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoDraw;
import lotto.enums.OutputMessage;

import java.util.Map;

public class OutputView {
    public static void outputNumberOfPurchaseLotto(LottoDraw lottoDraw) {
        int numberOfPurchases = lottoDraw.getPurchasesCount();
        System.out.println(String.format(OutputMessage.NUMBER_OF_PURCHASE_OUTPUT.getMessage(), numberOfPurchases));
        for (Lotto lotto : lottoDraw.getLottoDrawNumbers()) {
            System.out.println(lotto);
        }
    }

    public static void outputWinningResult(Map<String, Integer> winningLotto, Map<String, Integer> prizes) {
        System.out.println(OutputMessage.STRING_WINNING_STATISTIC_OUTPUT.getMessage());
        for (Map.Entry<String, Integer> entry : winningLotto.entrySet()) {
            System.out.println(winningResultOutputString(entry, prizes));
        }
    }

    public static void outputRateOfReturn(double profitRate) {
        System.out.println(String.format(
                OutputMessage.RATE_OF_RETURN_OUTPUT.getMessage(),
                profitRate
        ));
    }

    private static String winningResultOutputString(
            Map.Entry<String, Integer> winningResult,
            Map<String, Integer> prizes) {
        return String.format(
                OutputMessage.WINNING_STATISTICS_OUTPUT.getMessage(),
                winningResult.getKey(),
                prizes.get(winningResult.getKey()),
                winningResult.getValue()
        );
    }
}
