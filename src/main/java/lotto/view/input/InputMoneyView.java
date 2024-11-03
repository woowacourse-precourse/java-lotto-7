package lotto.view.input;

import lotto.exception.input.NotIntegerException;

public class InputMoneyView extends InputView {
    private static final String INPUT_MESSAGE = "금액을 입력해주세요";


    public Integer getValue() {
        System.out.println(INPUT_MESSAGE);
        String input = inputValue();
        validate(input);

        return Integer.parseInt(input);
    }

    private void validate(String input) {
        if (!Parser.isInteger(input)) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
