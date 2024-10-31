package lotto.exception;

public class NotThousandUnitException extends IllegalArgumentException {
    public NotThousandUnitException() {
        super("1,000원 단위로 구매 가능합니다.");
    }
}
