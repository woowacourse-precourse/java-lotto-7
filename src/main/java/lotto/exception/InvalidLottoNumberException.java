package lotto.exception;

public class InvalidLottoNumberException extends IllegalArgumentException {

    public InvalidLottoNumberException() {
        super("[ERROR] 당첨 번호를 다시 확인해 주세요.");
    }
}