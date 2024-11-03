package lotto.common.exception;

public class InvalidMoneyException extends LottoException{

    public InvalidMoneyException(int money) {
        super(ErrorMessage.MONEY_OUT_OF_RANGE.getMessage() + "(금액: " + money + ")");
    }

    public InvalidMoneyException(int money, Exception e) {
        super(ErrorMessage.MONEY_OUT_OF_RANGE.getMessage() + "(금액: " + money + ")", e);
    }
}
