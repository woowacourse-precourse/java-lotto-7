package lotto.io.exception;

public class StringToLongParsingException extends IllegalArgumentException {

    private StringToLongParsingException(final String s) {
        super(s);
    }

    public static StringToLongParsingException failedParsing(final String message) {
        throw new StringToLongParsingException(message);
    }
}
