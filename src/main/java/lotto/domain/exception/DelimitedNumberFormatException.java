package lotto.domain.exception;

public class DelimitedNumberFormatException extends NumberFormatException {

    public DelimitedNumberFormatException() {
        super();
    }

    public DelimitedNumberFormatException(String message) {
        super(message);
    }

    public static DelimitedNumberFormatException invalidNumber() {
        return new DelimitedNumberFormatException("당첨 번호는 숫자와 구분자로만 이루어져야 합니다.");
    }

}
