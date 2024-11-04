package lotto;

public class LottoPurchaseValidator {

    public static int validateAmount(String input) {
        validateNullOrEmpty(input);
        int amount = parseAmount(input.trim());
        validatePositiveAmount(amount);
        validateThousandUnit(amount);
        return amount;
    }

    private static void validateNullOrEmpty(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 입력이 null입니다.");
        }
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해주세요.");
        }
    }

    private static int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 정수만 입력할 수 있습니다. 혹은 너무 큰 숫자를 입력하셨습니다.");
        }
    }

    private static void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 큰 1,000원 단위 정수여야 합니다.");
        }
    }

    private static void validateThousandUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
