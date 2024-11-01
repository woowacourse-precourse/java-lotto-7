package lotto.view;

import lotto.Lotto;
import lotto.LottoDraw;
import lotto.message.OutputMessage;

public class OutputView {
    public static void outputNumberOfPurchaseLotto(LottoDraw lottoDraw) {
        int numberOfPurchases = lottoDraw.getNumberOfPurchases();
        System.out.println(String.format(OutputMessage.NUMBER_OF_PURCHASE_OUTPUT.getMessage(), numberOfPurchases));
        for (Lotto lotto : lottoDraw.getLottoDrawNumbers()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
