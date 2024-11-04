package lotto.exception.user;

public class NotThousandUnitException extends IllegalArgumentException {
    public NotThousandUnitException() {
        super("[ERROR] 1,000원 단위로 구매 가능합니다.");
    }
}
