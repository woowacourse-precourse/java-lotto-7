package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.validator.InputValidator;

public class InputView {

    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    public String inputPurchasePrice() {
        printMessage(INPUT_PURCHASE_PRICE_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateNull(input);
        InputValidator.validateInteger(input);
        return input;
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    public void close() {
        Console.close();
    }
}
