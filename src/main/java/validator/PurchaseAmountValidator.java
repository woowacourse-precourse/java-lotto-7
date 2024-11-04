package validator;

public class PurchaseAmountValidator {

    private static final int LOTTO_PRICE = 1000;

    public static int validate(String input) {
        int amount = parsePurchaseAmount(input);
        validatePositiveAmount(amount);
        validateNonZeroAmount(amount);
        validateThousandUnitAmount(amount);
        validateMinimumAmount(amount);
        return amount;
    }

    private static int parsePurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해 주세요.");
        }
    }

    private static void validatePositiveAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 음수가 아닌 양수여야 합니다.");
        }
    }

    private static void validateNonZeroAmount(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 0이 아닌 금액이어야 합니다.");
        }
    }

    private static void validateThousandUnitAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위여야 합니다.");
        }
    }

    private static void validateMinimumAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1,000원입니다.");
        }
    }
}
