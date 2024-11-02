package lotto.exception.Lotto;

public class NotDuplicatedNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "로또 번호는 중복되지 않아야 합니다.";

    public NotDuplicatedNumberException() {
        super(ERROR_MESSAGE);
    }
}
