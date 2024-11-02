package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final InputValidator inputValidator;

    public Input(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String input() {
        return Console.readLine();
    }

    public String getAmountWithMessage() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return input();
    }
}
