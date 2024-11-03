package lotto.validation;

public class PurchaseAmountValidator {

    private static final int THOUSAND = 1000;

    private PurchaseAmountValidator() {
    }

    public static void validateDivisibleByThousand(long amount) {
        if (amount % THOUSAND != 0) {
            throw new IllegalArgumentException("로또 구매 금액은 1000원 단위로 입력해야 합니다.");
        }
    }
}

