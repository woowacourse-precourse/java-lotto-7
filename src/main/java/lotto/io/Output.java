package lotto.io;

import lotto.util.Constants;

public class Output {
    public void printPurchasePriceInputPrompt() {
        System.out.println(Constants.PURCHASE_PRICE_INPUT_PROMPT.getMessage());
    }

    public void printLottoCount(int lottoCount) {
        System.out.println("\n "+ lottoCount + Constants.LOTTO_COUNT_PROMPT.getMessage());
    }
}
