package lotto.view;

import static lotto.utils.Constant.PURCHASE_AMOUNT_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.InputValidator;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);

        String userInput = Console.readLine();

        inputValidator.validatePurchaseAmount(userInput);

        return userInput;
    }
}
