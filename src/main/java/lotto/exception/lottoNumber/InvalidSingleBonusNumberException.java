package lotto.exception.lottoNumber;

import static lotto.exception.lottoNumber.Constants.INVALID_SINGLE_NUMBER_MESSAGE;

public class InvalidSingleBonusNumberException extends IllegalArgumentException {
    public InvalidSingleBonusNumberException() {
        super(INVALID_SINGLE_NUMBER_MESSAGE);
    }
}
