package lotto.validator;

public class InputValidator implements Validator<String> {

    @Override
    public void validate(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
