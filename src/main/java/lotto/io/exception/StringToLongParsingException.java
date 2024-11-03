package lotto.io.exception;

public class StringToLongParsingException extends IllegalArgumentException {

    private StringToLongParsingException(final String message) {
        super(message);
    }

    public static StringToLongParsingException failedParsing(final String message) {
        throw new StringToLongParsingException(message);
    }
}
