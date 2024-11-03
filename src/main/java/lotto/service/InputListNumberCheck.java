package lotto.service;

import java.util.List;

public class InputListNumberCheck {

    private final List<String> input;

    public InputListNumberCheck(List<String> input) {
        isNumber(input);
        this.input = input;
    }

    private void isNumber(List<String> winningInput) {
        for (String input : winningInput) {
            boolean num = input.matches("[+-]?\\d*(\\.\\d+)?");

            if (!num) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
            }
        }
    }
}
