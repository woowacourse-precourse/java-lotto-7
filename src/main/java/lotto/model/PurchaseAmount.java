package lotto.model;

import lotto.constants.ErrorMessages;

public class PurchaseAmount{
    public static final Integer LOTTE_PRICE=1000;
    private final Integer money;

    public PurchaseAmount(Integer money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(Integer money) {
        validateNonNegative(money);
        validateDivisibleByLottoPrice(money);
    }

    private void validateDivisibleByLottoPrice(Integer money) {
        if(money%LOTTE_PRICE!=0){
            throw new IllegalArgumentException(ErrorMessages.AMOUNT_MUST_BE_DIVISIBLE_BY_1000);
        }

    }

    private void validateNonNegative(Integer money) {
        if(money<=0){
            throw new IllegalArgumentException(ErrorMessages.AMOUNT_MUST_BE_POSITIVE);
        }
    }

    public Integer getMoney() {
        return money;
    }
}
