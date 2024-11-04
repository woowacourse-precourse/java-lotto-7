package lotto.week3.global.error.validate;

public class PurchaseAmountValidator {


    // 금액 유효성 검증 메서드
    public static int validate(String input) {
        checkIfEmpty(input);
        int amount = parseToInt(input);
        checkMinimumAmount(amount);
        checkThousandUnit(amount);
        return amount;
    }

    // 1. 입력이 비어있는지 확인
    private static void checkIfEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력이 비어 있습니다. 금액을 입력해 주세요.");
        }
    }

    // 2. 입력을 정수로 변환
    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해 주세요.");
        }
    }

    // 3. 최소 금액 확인 (1,000원 이상)
    private static void checkMinimumAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1,000원입니다.");
        }
    }

    // 4. 1,000원 단위 확인
    private static void checkThousandUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해 주세요.");
        }
    }
}
