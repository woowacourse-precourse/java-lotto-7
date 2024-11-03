package lotto.config.exception.bonus;

import lotto.config.exception.GlobalException;

public class BonusException extends GlobalException {
    public BonusException(BonusExceptionMessage message) {
        super(message.getMessage());
    }
}
