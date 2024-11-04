package lotto.exception.money;

public class MoneyAmountOutOfRangeException extends IllegalArgumentException {

    private static final String MESSAGE = "구입금액은 %d원 이상, %d원 이하 입니다.";

    public MoneyAmountOutOfRangeException(int minMoneyAmount, int maxMoneyAmount) {
        super(String.format(MESSAGE, minMoneyAmount, maxMoneyAmount));
    }
}
