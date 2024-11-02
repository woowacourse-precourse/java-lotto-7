package lotto.exception.model;

public class LottoExceptionBase extends IllegalArgumentException {

    protected LottoExceptionBase(String message) {
        super(message);
    }
}
