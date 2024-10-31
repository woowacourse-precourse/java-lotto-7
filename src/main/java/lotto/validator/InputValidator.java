package lotto.validator;

public class InputValidator implements Validator {

    @Override
    public void validator(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
