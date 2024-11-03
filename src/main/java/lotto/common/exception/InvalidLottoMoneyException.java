package lotto.common.exception;

public class InvalidLottoMoneyException extends LottoException{

    public InvalidLottoMoneyException(int money) {
        super(ErrorMessage.MONEY_OUT_OF_RANGE.getMessage() + "(금액: " + money + ")");
    }

    public InvalidLottoMoneyException(int money, Exception e) {
        super(ErrorMessage.MONEY_OUT_OF_RANGE.getMessage() + "(금액: " + money + ")", e);
    }
}
