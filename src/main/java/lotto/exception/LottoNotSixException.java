package lotto.exception;

public class LottoNotSixException extends IllegalArgumentException {

    public LottoNotSixException() {
        super("[ERROR] 로또 번호는 6개여야 합니다.");
    }
}