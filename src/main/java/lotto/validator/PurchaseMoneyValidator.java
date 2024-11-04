package lotto.validator;

public class PurchaseMoneyValidator {
    private PurchaseMoneyValidator() {
    }

    public static void validateInteger(String token) {
        try {
            Integer.parseInt(token);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수 형태의 숫자가 아닙니다.");
        }
    }

    public static void validateDivisibleByThousand(int purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000으로 나누어 떨어지지 않습니다.");
        }
    }
}
