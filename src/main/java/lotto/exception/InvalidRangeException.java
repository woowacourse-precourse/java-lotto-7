package lotto.exception;

public class InvalidRangeException extends IllegalArgumentException {
    private InvalidRangeException(final String s) {
        super(s);
    }

    public static InvalidRangeException invalidLottoLength(final String message) {
        throw new InvalidRangeException(message);
    }

    public static InvalidRangeException invalidLottoNumberRange(final String message) {
        throw new InvalidRangeException(message);
    }
}
