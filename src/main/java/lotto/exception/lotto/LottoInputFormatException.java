package lotto.exception.lotto;

public class LottoInputFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 올바른 로또 번호 입력 형식이 아닙니다.";

    public LottoInputFormatException() {
        super(ERROR_MESSAGE);
    }
}
