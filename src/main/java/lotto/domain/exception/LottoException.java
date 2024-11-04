package lotto.domain.exception;

public class LottoException extends NumberFormatException {

    public LottoException() {
        super();
    }

    public LottoException(String message) {
        super(message);
    }

    public static LottoException invalidCount() {
        return new LottoException("로또 번호는 정확히 6개여야 합니다.");
    }

    public static LottoException invalidNumber() {
        return new LottoException("로또 번호는 숫자로만 이루어져야 합니다.");
    }

    public static LottoException outOfRange() {
        return new LottoException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    public static LottoException duplicate() {
        return new LottoException("로또 번호는 중복되지 않아야 합니다.");
    }
}
