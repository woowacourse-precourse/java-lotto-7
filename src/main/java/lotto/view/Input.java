package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구매 금액을 입력해주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해주세요.";

    public String printPurchaseAmountInputMessage() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);

        return Console.readLine();
    }

    public String printWinningNumberInputMessage() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);

        return Console.readLine();
    }

    public String printBonusNumberInputMessage() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);

        return Console.readLine();
    }

}
