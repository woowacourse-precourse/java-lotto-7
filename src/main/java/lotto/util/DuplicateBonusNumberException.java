package lotto.util;

import static lotto.constant.ErrorMessage.DUPLICATE_BONUS_NUMBER;

public class DuplicateBonusNumberException extends RuntimeException {
    public DuplicateBonusNumberException() {
        super(DUPLICATE_BONUS_NUMBER.getMessage());
    }
}