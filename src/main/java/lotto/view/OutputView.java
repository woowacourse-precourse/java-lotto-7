package lotto.view;

import lotto.message.SystemMessage;

public class OutputView {

    /**
     * 사용자에게 구매 금액 입력 문구 출력
     */
    public static void printPurchaseAmountMessage() {
        System.out.println(SystemMessage.MESSAGE_INPUT_PURCHASE_AMOUNT.getMessage());
    }

}
