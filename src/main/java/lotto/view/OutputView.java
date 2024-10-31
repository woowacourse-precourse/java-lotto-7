package lotto.view;

import lotto.constant.Message;

public class OutputView {
    public void printReadPurchaseAmount() {
        System.out.println(Message.PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public void printLottoPurchaseResult(int numberOfLotto) {
        System.out.println();
        System.out.println(numberOfLotto + Message.PURCHASE_RESULT_MESSAGE);
    }

    public void printLottoState(String lottosState) {
        System.out.println(lottosState);
    }
}
