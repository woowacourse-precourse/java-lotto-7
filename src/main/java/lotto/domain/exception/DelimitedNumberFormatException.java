package lotto.domain.exception;

public class DelimitedNumberFormatException extends NumberFormatException {

    public DelimitedNumberFormatException() {
        super();
    }

    public DelimitedNumberFormatException(String message) {
        super(message);
    }

    public static DelimitedNumberFormatException invalidCount() {
        return new DelimitedNumberFormatException("당첨 번호는 정확히 6개여야 합니다.");
    }

    public static DelimitedNumberFormatException invalidNumber() {
        return new DelimitedNumberFormatException("당첨 번호는 숫자와 구분자로만 이루어져야 합니다.");
    }

    public static DelimitedNumberFormatException outOfRange() {
        return new DelimitedNumberFormatException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
