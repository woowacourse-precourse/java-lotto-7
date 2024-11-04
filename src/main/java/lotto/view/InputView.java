package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void printPurchaseAmountInputMessage() {
        System.out.println(System.lineSeparator() + PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public void printWinningNumberInputMessage() {
        System.out.println(System.lineSeparator() + WINNING_NUMBER_INPUT_MESSAGE);
    }

    public void printBonusNumberInputMessage() {
        System.out.println(System.lineSeparator() + BONUS_NUMBER_INPUT_MESSAGE);
    }

    public String getInput() {
        return Console.readLine().trim();
    }
}
