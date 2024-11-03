package lotto.view.input;

import lotto.parsers.Parser;

public class InputMoneyView extends InputView {
    public Integer getValue() {
        System.out.println("구입 금액을 입력해주세요.");
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
