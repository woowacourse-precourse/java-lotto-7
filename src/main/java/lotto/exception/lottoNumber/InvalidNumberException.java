package lotto.exception.lottoNumber;

import static lotto.exception.lottoNumber.Constants.INVALID_NUMBER_MESSAGE;

public class InvalidNumberException extends IllegalArgumentException {
    public InvalidNumberException() {
        super(INVALID_NUMBER_MESSAGE);
    }
}
