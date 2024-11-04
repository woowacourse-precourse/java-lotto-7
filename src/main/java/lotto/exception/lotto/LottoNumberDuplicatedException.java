package lotto.exception.lotto;

public class LottoNumberDuplicatedException extends IllegalArgumentException {

    private static final String MESSAGE = "로또 번호에 중복된 숫자가 있습니다.";

    public LottoNumberDuplicatedException() {
        super(MESSAGE);
    }
}
