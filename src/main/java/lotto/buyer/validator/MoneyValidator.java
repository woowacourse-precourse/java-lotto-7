package lotto.buyer.validator;

import lotto.constant.LottoConstant;

public class MoneyValidator {
    public static void validate(Long money) {
        limitAmountValidator(money);
        divisibleByThousandValidator(money);
    }
    private static void divisibleByThousandValidator(Long money) {
        if (money % LottoConstant.PURCHASE_AMOUNT.getValue() != 0) throw new IllegalArgumentException("[ERROR] 천원으로 나눠지게 입력해주세요");
    }
    private static void limitAmountValidator(Long money) {
        if (money > LottoConstant.PURCHASE_LIMIT_AMOUNT.getValue()) throw new IllegalArgumentException("[ERROR] 금액은 10만원 이하로 입력해주세요");
    }
}