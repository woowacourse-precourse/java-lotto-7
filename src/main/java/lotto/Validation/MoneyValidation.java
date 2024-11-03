package lotto.Validation;

public class MoneyValidation {
    public static void MoneyInputNotNull(String MoneyInput) {
        if (MoneyInput == null || MoneyInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구매 금액을 입력해야 합니다.");
        }
    }

    public static void MoneyIsNumeric(String MoneyInput) {
        if (!MoneyInput.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자를 입력해야 합니다.");
        }

    }

    public static void MoneyDivisibleByThousand(int money) {
        if (money%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

}