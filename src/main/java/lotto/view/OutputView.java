package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.utils.ConstantMessage.GuideMessage;
import lotto.utils.LottoPrize;

public class OutputView {
    static final String START_PHRASE = "[";
    static final String END_PHRASE = "]";
    static final String SEPARATE_PHRASE = ", ";

    public void printGuide(GuideMessage guideMessage) {
        System.out.println(guideMessage.getMessage());
    }

    public void printBlank() {
        System.out.println();
    }

    public void printPurchasedAmount(int amount) {
        System.out.printf(GuideMessage.PURCHASED_AMOUNT.getMessage() + "\n", amount);
    }

    public void printLottoNumber(Lotto lotto) {
        List<String> lottoOutput = lotto.getNumbers().stream()
                .map(number -> Integer.toString(number))
                .toList();

        System.out.println(START_PHRASE + String.join(SEPARATE_PHRASE, lottoOutput) + END_PHRASE);
    }

    public void printCountResult(Map<String, Integer> countMap) {
        List<LottoPrize> prizeOrder = Arrays.asList(
                LottoPrize.MATCH_THREE,
                LottoPrize.MATCH_FOUR,
                LottoPrize.MATCH_FIVE,
                LottoPrize.MATCH_FIVE_PLUS_BONUS,
                LottoPrize.MATCH_SIX
        );
        prizeOrder.forEach(lottoPrize -> {
            System.out.printf(
                    lottoPrize.getPrizeMessage() + "\n",
                    countMap.get(lottoPrize.name())
            );
        });
    }

    public void printReturnResult(float returnRate) {
        System.out.printf(GuideMessage.RESULT_OF_RETURN.getMessage(), returnRate);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
