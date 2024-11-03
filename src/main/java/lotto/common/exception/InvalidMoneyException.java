package lotto.common.exception;

public class InvalidMoneyException extends LottoException{

    public InvalidMoneyException(long money) {
        super(ErrorMessage.MONEY_OUT_OF_RANGE.getMessage() + "(금액: " + money + ")");
    }

    public InvalidMoneyException(long money, Exception e) {
        super(ErrorMessage.MONEY_OUT_OF_RANGE.getMessage() + "(금액: " + money + ")", e);
    }
}
