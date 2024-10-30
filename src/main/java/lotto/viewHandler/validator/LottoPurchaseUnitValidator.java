package lotto.viewHandler.validator;

import lotto.viewHandler.exception.NotUnitPurchaseMoney;
import lotto.viewHandler.Validator;

public class LottoPurchaseUnitValidator implements Validator<Void, Integer> {
    @Override
    public Void validate(Integer getPurchase) {
        if(getPurchase % 1000 != 0) {
            throw new NotUnitPurchaseMoney("1,000원 단위가 아닙니다.");
        }
        return null;
    }
}
