package lotto.service;

import java.util.List;

public class InputListNullCheck {
    private final List<String> inputList;

    public InputListNullCheck(List<String> inputList) {
        nullCheck(inputList);
        this.inputList = inputList;
    }

    private void nullCheck(List<String> input) {
        if (input == null || input.contains("")) {
            throw new IllegalArgumentException("[ERROR] 아무것도 입력하지 않았습니다. 입력해 주세요.");
        }
    }
}
