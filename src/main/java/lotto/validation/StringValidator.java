package lotto.validation;

public class StringValidator implements Validator<String> {
    private final String errorMessage;

    public StringValidator(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void validate(String value) {
        if (value == null || value.trim().isEmpty() || !value.matches("^\\d+(,\\d+){5}$")) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
