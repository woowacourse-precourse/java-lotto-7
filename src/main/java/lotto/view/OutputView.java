package lotto.view;

import lotto.constant.OutputMessage;

public class OutputView {

    public void printPurchaseGuide() {
        System.out.println(OutputMessage.PURCHASE_GUIDE.getMessage());
    }

    public void printPurchaseAmount(int amount) {
        System.out.println(String.format(OutputMessage.PURCHASE_AMOUNT.getMessage(), amount));
    }
}
