package lotto;

public class LottoInputValidator {
    private final String string;

    public LottoInputValidator(String string) {
        validateLottoNumberExists(string);
        validateLottoNumberNumeric(string);
        this.string = string;
    }

    private void validateLottoNumberNumeric(String string) {
        if (!string.matches("\\d+")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_FORMAT.getErrorMessage());
        }
    }

    private void validateLottoNumberExists(String string) {
        if (string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT.getErrorMessage());
        }
    }
}
