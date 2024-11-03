package lotto.exception.lottoNumber;

import static lotto.exception.lottoNumber.Constants.NOT_FOUND_DELIMITER_MESSAGE;

public class NotFoundDelimiterException extends IllegalArgumentException {
    public NotFoundDelimiterException() {
        super(NOT_FOUND_DELIMITER_MESSAGE);
    }
}
