package lotto.view;

import static lotto.constant.MessageConstant.INPUT_BONUS_NUMBER;
import static lotto.constant.MessageConstant.INPUT_PURCHASE_AMOUNT;
import static lotto.constant.MessageConstant.INPUT_WINNING_NUMBER;
import static lotto.constant.MessageConstant.NEWLINE;
import static lotto.view.InputValidator.validateIsNumeric;
import static lotto.view.InputValidator.validateNotNullOrBlank;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readPurchaseAmount() {
        return readInput(INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public String readWinningNumber() {
        System.out.printf(NEWLINE.getMessage());
        return readInput(INPUT_WINNING_NUMBER.getMessage());
    }

    public String readBonusNumber() {
        System.out.printf(NEWLINE.getMessage());
        return readInput(INPUT_BONUS_NUMBER.getMessage());
    }

    private String readInput(String message) {
        System.out.println(message);
        String input = Console.readLine();

        validateNotNullOrBlank(input);
        validateIsNumeric(input);

        return input;
    }
}
