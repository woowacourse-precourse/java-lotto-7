package lotto.exception;

public class InvalidLottoDuplicateException extends IllegalArgumentException {

    public InvalidLottoDuplicateException() {
        super("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }
}
