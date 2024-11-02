package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final InputValidator inputValidator;

    public Input(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public Integer getAmountWithMessage() {
        while (true) {
            try {
                return getValidatedAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer getValidatedAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        Integer amount = Parser.toInteger(Console.readLine());
        inputValidator.validateAmount(amount);
        return amount;
    }
}
