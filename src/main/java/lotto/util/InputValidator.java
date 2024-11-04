package lotto.util;

public class InputValidator {

    public static void isNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 빈칸입니다. 다시 입력해주세요.");
        }
    }

    public static void isNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈칸입니다. 다시 입력해주세요.");
        }
    }

    public static void isMinimumAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 주문 금액은 1000원입니다.");
        }
    }

    public static void isMultipleOfThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 주문할 수 있습니다.");
        }
    }
}
