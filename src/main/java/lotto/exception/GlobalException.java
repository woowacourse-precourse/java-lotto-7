package lotto.exception;

import lotto.exception.common.BaseException;
import lotto.exception.message.InputExceptionMessage;
import lotto.exception.message.LottoExceptionMessage;
import lotto.exception.message.LottoMoneyExceptionMessage;
import lotto.exception.message.WinningNumberExceptionMessage;

public class GlobalException {

    public static class InputException extends BaseException {
        public InputException(InputExceptionMessage message) {
            super(message);
        }
    }

    public static class LottoException extends BaseException {
        public LottoException(LottoExceptionMessage message) {
            super(message);
        }
    }

    public static class MoneyException extends BaseException {
        public MoneyException(LottoMoneyExceptionMessage message) {
            super(message);
        }
    }

    public static class WinningNumberException extends BaseException {
        public WinningNumberException(WinningNumberExceptionMessage message) {
            super(message);
        }
    }

}
