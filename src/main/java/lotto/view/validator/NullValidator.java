package lotto.view.validator;


public class NullValidator extends InputValidator {

    private final String errorMessage;

    protected NullValidator(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void validate(final String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}