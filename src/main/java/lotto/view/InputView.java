package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.validator.InputValidator;

public class InputView {

    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String inputPurchasePrice() {
        printMessage(INPUT_PURCHASE_PRICE_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateNull(input);
        InputValidator.validateInteger(input);
        InputValidator.validatePositiveNumber(input);
        return input;
    }

    public String inputWinningNumbers() {
        printMessage(INPUT_WINNING_NUMBERS_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateContainsComma(input);
        InputValidator.validateCommaFormat(input);
        return input;
    }

    public String inputBonusNumber() {
        printMessage(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        return input;
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    public void close() {
        Console.close();
    }
}
