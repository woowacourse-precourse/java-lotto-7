package lotto.exception.lottoNumber;

import static lotto.exception.lottoNumber.Constants.DUPLICATED_NUMBER_MESSAGE;

public class DuplicatedNumberException extends IllegalArgumentException {
    public DuplicatedNumberException() {
        super(DUPLICATED_NUMBER_MESSAGE);
    }
}
