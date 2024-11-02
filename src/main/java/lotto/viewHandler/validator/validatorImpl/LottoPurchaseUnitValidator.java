package lotto.viewHandler.validator.validatorImpl;

import lotto.viewHandler.exception.NotUnitPurchaseMoney;
import lotto.viewHandler.validator.Validator;

import static lotto.domain.PurchaseLottos.LOTTO_UNIT;
import static lotto.viewHandler.exception.MyExceptionConstant.NOT_MONEY_UNIT;
import static lotto.viewHandler.exception.MyExceptionConstant.ZERO;

public class LottoPurchaseUnitValidator implements Validator<Void, Integer> {
    @Override
    public Void validate(Integer getPurchase) {
        if (getPurchase % LOTTO_UNIT != ZERO) {
            throw new NotUnitPurchaseMoney(NOT_MONEY_UNIT);
        }
        return null;
    }
}
