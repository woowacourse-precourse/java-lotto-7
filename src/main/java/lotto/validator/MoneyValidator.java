package lotto.validator;

public class MoneyValidator {
    private MoneyValidator() {
    }

    public static void isNumeric(String value) {
        try {
            int money = Integer.parseInt(value);
        } catch (Exception e) {
            throw new NumberFormatException("구입 금액은 숫자를 입력해주세요.");
        }
    }

    public static void isPositive(String value) {
        int money = Integer.parseInt(value);
        if (money <= 0) {
            throw new IllegalArgumentException("구입 금액은 양수를 입력해주세요.");
        }
    }

    public static void checkDivisibleByThousand(String value) {
        int money = Integer.parseInt(value);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
        }
    }
}
