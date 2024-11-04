package lotto.exception.administrator;

public class LottoNumbersMustBeSixException extends IllegalArgumentException {
    public LottoNumbersMustBeSixException() {
        super("[ERROR] 로또 번호는 6개여야 합니다.");
    }
}
