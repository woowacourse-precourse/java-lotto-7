package lotto.validator;

public class MoneyValidator {
    public static void validateMoneyInputNotNull(String inputMoney) {
        if (inputMoney == null) {
            throw new IllegalArgumentException("[ERROR] 돈을 입력해야 합니다.");
        }
    }

    public static void validateMoneyIsNumeric(String inputMoney) {
        if (!inputMoney.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 돈은 숫자를 입력해야 합니다.");
        }

    }

    public static void validateMoneyDivisibleByThousand(int money) {
        if (money%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하셔야 합니다.");
        }
    }

}
