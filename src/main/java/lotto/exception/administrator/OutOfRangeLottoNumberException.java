package lotto.exception.administrator;

public class OutOfRangeLottoNumberException extends IllegalArgumentException {
    public OutOfRangeLottoNumberException() {
        super("[ERROR] 당첨 번호는 1 ~ 45 범위 내로 입력해주세요.");
    }
}
