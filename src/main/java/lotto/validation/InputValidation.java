package lotto.validation;

public class InputValidation {

    public void checkNotNullAndNotBlank(String input) {
        if (input.trim().isBlank()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

}
