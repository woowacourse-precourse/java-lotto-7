package lotto.exception;

import lotto.exception.common.BaseException;
import lotto.exception.message.LottoMoneyExceptionMessage;

public class MoneyException extends BaseException {

    public MoneyException(LottoMoneyExceptionMessage message) {
        super(message);
    }

}
