package lotto.week3.global.error.validate;

import lotto.week3.global.error.message.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY.getMessage());
        }
    }

    // 2. 입력을 정수로 변환
    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PLEASE_ENTER_THE_AMOUNT_IN_NUMBERS.getMessage());
        }
    }

    // 3. 최소 금액 확인 (1,000원 이상)
    private static void checkMinimumAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
    }

    // 4. 1,000원 단위 확인
    private static void checkThousandUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT.getMessage());
        }
    }
}
