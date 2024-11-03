package lotto.service;

public class InputNumberCheck {

    private final String input;

    public InputNumberCheck(String input) {
        isNumber(input);
        this.input = input;
    }

    private void isNumber(String input) {
        boolean isNum = input.matches("[+-]?\\d*(\\.\\d+)?");

        if (!isNum) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }
}
