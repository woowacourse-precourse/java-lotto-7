package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoDraw;
import lotto.domain.LottoPrizeMap;
import lotto.service.LottoWinning;
import lotto.service.CalculateProfitRate;
import lotto.enums.OutputMessage;

import java.util.Map;

public class OutputView {
    public static void outputNumberOfPurchaseLotto(LottoDraw lottoDraw) {
        int numberOfPurchases = lottoDraw.getNumberOfPurchases();
        System.out.println(String.format(OutputMessage.NUMBER_OF_PURCHASE_OUTPUT.getMessage(), numberOfPurchases));
        for (Lotto lotto : lottoDraw.getLottoDrawNumbers()) {
            System.out.println(lotto);
        }
    }

    public static void outputWinningResult(LottoWinning lottoWinning, LottoPrizeMap lottoPrizeMap) {
        System.out.println(OutputMessage.STRING_WINNING_STATISTIC_OUTPUT.getMessage());
        Map<String, Integer> winningResult = lottoWinning.getWinningLotto();
        Map<String, Integer> prizes = lottoPrizeMap.getPrizes();

        for (Map.Entry<String, Integer> entry : winningResult.entrySet()) {
            System.out.println(winningResultOutputString(entry, prizes));
        }
    }

    private static String winningResultOutputString(
            Map.Entry<String, Integer> winningResult,
            Map<String, Integer> prizes
    ) {
        return String.format(
                OutputMessage.WINNING_STATISTICS_OUTPUT.getMessage(),
                winningResult.getKey(),
                prizes.get(winningResult.getKey()),
                winningResult.getValue()
        );
    }

    public static void outputRateOfReturn(CalculateProfitRate calculateRateOfReturn) {
        System.out.println(String.format(
                OutputMessage.RATE_OF_RETURN_OUTPUT.getMessage(),
                calculateRateOfReturn.getProfitRate()
        ));
    }
}
