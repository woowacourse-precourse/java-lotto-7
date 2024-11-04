package lotto.exception.winning;

import static lotto.exception.errorMessage.IllegalArgumentExceptionMessage.LOTTO_NUMBER_DUPLICATED;

public class LottoNumberDuplicatedException extends IllegalArgumentException {
    public LottoNumberDuplicatedException() {
        super(LOTTO_NUMBER_DUPLICATED.getMessage());
    }
}
