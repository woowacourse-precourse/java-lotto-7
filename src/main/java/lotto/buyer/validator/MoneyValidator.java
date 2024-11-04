package lotto.buyer.validator;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;

public class MoneyValidator {
    public static void validate(Long money) {
        limitAmountValidator(money);
        divisibleByThousandValidator(money);
    }
    private static boolean isExceedingPurchaseLimit(long money) {
        return money > LottoConstant.PURCHASE_LIMIT_AMOUNT.getValue();
    }

    private static boolean isNotDivisibleByPurchaseUnit(long money) {
        return money % LottoConstant.PURCHASE_AMOUNT.getValue() != 0;
    }
    private static void divisibleByThousandValidator(long money) {
        if (isNotDivisibleByPurchaseUnit(money)) ErrorMessage.DIVISIBLE_BY_THOUSAND.throwIllegalArgumentException();
    }
    private static void limitAmountValidator(long money) {
        if (isExceedingPurchaseLimit(money)) ErrorMessage.AMOUNT_LIMIT.throwIllegalArgumentException();
    }
}