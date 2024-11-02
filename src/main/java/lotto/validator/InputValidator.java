package lotto.validator;

public class InputValidator implements Validator {

    @Override
    public void validate(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력하실 수 없습니다.");
        }
    }
}
