package lotto.service;

import java.util.List;

public class InputNullCheck {
    private final String input;

    public InputNullCheck(String input) {
        nullCheck(input);
        this.input = input;
    }

    private void nullCheck(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 아무것도 입력하지 않았습니다. 입력해 주세요.");
        }
    }

}
