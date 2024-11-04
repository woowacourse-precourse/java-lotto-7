package lotto.exception.administrator;

public class LottoNumbersDuplicationException extends IllegalArgumentException {
    public LottoNumbersDuplicationException() {
        super("[ERROR] 당첨 번호는 중복이 안됩니다.");
    }
}
