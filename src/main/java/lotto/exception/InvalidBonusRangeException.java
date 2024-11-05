package lotto.exception;

public class InvalidBonusRangeException extends IllegalArgumentException {

    public InvalidBonusRangeException() {
        super("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
