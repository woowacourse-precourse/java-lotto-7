package lotto.input.validator;

public class LottoPurchaseAmountValidator {

    private final static String LOTTO_PURCHASE_AMOUNT_REGEX = "^[1-9][0-9]*000$";

    public void validate(String input) {
        if (!input.matches(LOTTO_PURCHASE_AMOUNT_REGEX))
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }
}
