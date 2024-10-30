package lotto.viewHandler.validator;

import lotto.viewHandler.exception.NotUnitPurchaseMoney;
import lotto.viewHandler.Validator;

import static lotto.viewHandler.exception.ExceptionMessage.MONEY_UNIT;
import static lotto.viewHandler.exception.ExceptionMessage.NOT_MONEY_UNIT;

public class LottoPurchaseUnitValidator implements Validator<Void, Integer> {
    @Override
    public Void validate(Integer getPurchase) {
        if(getPurchase % MONEY_UNIT != 0) {
            throw new NotUnitPurchaseMoney(NOT_MONEY_UNIT);
        }
        return null;
    }
}
