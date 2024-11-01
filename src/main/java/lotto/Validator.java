package lotto;

public class Validator {
    private static final String COMMON_ERROR_MESSAGE = "[ERROR] ";
    private static final String NUMBER_ERROR_MESSAGE = "입력은 숫자 형태여야 합니다.";
    private static final String POSITIVE_RANGE_ERROR_MESSAGE = "양수 범위 내에서 입력 가능합니다.";
    private static final String LOTTERY_RANGE_ERROR_MESSAGE = "로또 번호는 1부터 45 사이의 값이어야 합니다";

    private static final int LOTTERY_NUM_RANGE_FIRST = 1;
    private static final int LOTTERY_NUM_RANGE_LAST = 45;

    private void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    private void isPositiveNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException(POSITIVE_RANGE_ERROR_MESSAGE);
        }
    }

    private void isLotteryRange(int num) {
        if (num < LOTTERY_NUM_RANGE_FIRST || LOTTERY_NUM_RANGE_LAST < num) {
            throw new IllegalArgumentException(LOTTERY_RANGE_ERROR_MESSAGE);
        }
    }

    public void validatePurchaseAmount(String purchaseInput) {
        try {
            isNumber(purchaseInput);
            int num = Integer.parseInt(purchaseInput);
            isPositiveNumber(num);
            isLotteryRange(num);
        } catch (IllegalArgumentException e) {
            System.out.println(COMMON_ERROR_MESSAGE + e.getMessage());
        }
    }
}
