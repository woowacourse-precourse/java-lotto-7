package lotto.validation;

public class InputValidation {

    public void checkNotNullAndNotBlank(String input) {
        if (input.trim().isBlank()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    public void checkIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
    }

}
