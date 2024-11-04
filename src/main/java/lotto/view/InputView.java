package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String inputPurchaseAmount() {
        printInputPurchaseAmount();
        return Console.readLine();
    }

    public String inputWinningNumber() {
        printInputWinningNumbers();
        return Console.readLine();
    }

    public String inputBonusNumber() {
        printInputBonusNumber();
        return Console.readLine();
    }

    private void printInputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    private void printInputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    }

    private void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

}
