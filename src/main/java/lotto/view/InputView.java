package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.InputValidator;

public class InputView {
    private final static String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
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
