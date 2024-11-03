package lotto.view;

import lotto.message.SystemMessage;

public class OutputView {

    /**
     * 사용자에게 구매 금액 입력 문구 출력
     */
    public static void printPurchaseAmountMessage() {
        System.out.println(SystemMessage.MESSAGE_INPUT_PURCHASE_AMOUNT.getMessage());
    }

    /**
     * 사용자에게 로또 번호 입력 문구 출력
     */
    public static void printLottoNumbersMessage() {
        System.out.println(SystemMessage.MESSAGE_INPUT_LOTTO_NUMBERS.getMessage());
    }

    /**
     * 사용자에게 보너스 번호 입력 문구 출력
     */
    public static void printBonusNumberMessage() {
        System.out.println(SystemMessage.MESSAGE_INPUT_BONUS_NUMBER.getMessage());
    }
}
