package lotto.exception;

import static lotto.constant.ExceptionMessageConstants.EXACT_CHANGE_NOT_POSSIBLE_ERROR;

public class ExactChangeNotPossibleException extends IllegalArgumentBaseException {

    public ExactChangeNotPossibleException() {
        super(EXACT_CHANGE_NOT_POSSIBLE_ERROR.getMessage());
    }
}
