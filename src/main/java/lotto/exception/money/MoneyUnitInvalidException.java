package lotto.exception.money;

public class MoneyUnitInvalidException extends IllegalArgumentException {

    private static final String MESSAGE = "구입금액은 %d원 단위입니다.";

    public MoneyUnitInvalidException(int moneyUnit) {
        super(String.format(MESSAGE, moneyUnit));
    }
}
