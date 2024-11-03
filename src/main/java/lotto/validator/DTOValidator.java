package lotto.validator;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class DTOValidator {

    public void NotNull(String inputStr) {
        if (inputStr == null) {
            throw LottoException.from(ErrorMessage.NULL_INPUT_ERROR);
        }
    }

    public void Empty(String inputStr) {
        if (inputStr.isEmpty()) {
            throw LottoException.from(ErrorMessage.EMPTY_INPUT_ERROR);
        }
    }
}
