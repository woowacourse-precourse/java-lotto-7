package lotto.io.exception;

public class InvalidRegexException extends IllegalArgumentException {
    private InvalidRegexException(final String message) {
        super(message);
    }

    public static InvalidRegexException invalidMoneyRegex(final String message) {
        throw new InvalidRegexException(message);
    }
}
