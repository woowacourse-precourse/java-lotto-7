package lotto.view;

import lotto.Lotto;
import lotto.LottoDraw;
import lotto.enums.InputMessage;
import lotto.enums.LottoPrize;
import lotto.enums.OutputMessage;
import lotto.LottoWinning;

import java.util.LinkedHashMap;
import java.util.Map;

public class OutputView {
    public static void outputNumberOfPurchaseLotto(LottoDraw lottoDraw) {
        int numberOfPurchases = lottoDraw.getNumberOfPurchases();
        System.out.println(String.format(OutputMessage.NUMBER_OF_PURCHASE_OUTPUT.getMessage(), numberOfPurchases));
        for (Lotto lotto : lottoDraw.getLottoDrawNumbers()) {
            System.out.println(lotto);
        }
    }

    public static void outputWinningResult(LottoWinning lottoWinning) {
        System.out.println(OutputMessage.STRING_WINNING_STATISTIC_OUTPUT.getMessage());
        Map<String, Integer> winningResult = lottoWinning.getWinningLotto();
        Map<String, Integer> prizes = setPrizes();
        for (Map.Entry<String, Integer> entry : winningResult.entrySet()) {
            Integer prize = prizes.get(entry.getKey());
            String outputString = String.format(
                    OutputMessage.WINNING_STATISTICS_OUTPUT.getMessage(),
                    entry.getKey(),
                    prize,
                    entry.getValue()
            );

            System.out.println(outputString);
        }
    }

    private static Map<String, Integer> setPrizes() {
        Map<String, Integer> setPrizes = new LinkedHashMap<>();
        setPrizes.put("3개 일치", LottoPrize.THREE_WINNING_PRIZE.getPrize());
        setPrizes.put("4개 일치", LottoPrize.FOUR_WINNING_PRIZE.getPrize());
        setPrizes.put("5개 일치", LottoPrize.FIVE_WINNING_PRIZE.getPrize());
        setPrizes.put("5개 일치, 보너스 볼 일치", LottoPrize.FIVE_WINNING_WITH_BONUS_PRIZE.getPrize());
        setPrizes.put("6개 일치", LottoPrize.SIX_WINNING_PRIZE.getPrize());
        return setPrizes;
    }
}
