package lotto.validator;

public class LottoPurchaseAmountValidator {
    private static final String LOTTO_PURCHASE_AMOUNT_REGEX = "^[0-9]+$";
    private static final int LOTTO_PURCHASE_AMOUNT_UNIT = 1000;
    private static final int REMAINDER = 0;

    private LottoPurchaseAmountValidator() {
    }

    public static void validateLottoPurchaseAmount(String lottoPurchaseAmount) {
        try {
            int parseValue = Integer.parseInt(lottoPurchaseAmount);
            checkThousandWonUnit(parseValue);
            checkLottoPurchaseAmountRange(parseValue);
        } catch (NumberFormatException e) {
            checkIncludeSpecialCharacters(lottoPurchaseAmount);
            throw new IllegalArgumentException("로또 구입 금액의 값이 자료형의 범위를 넘어갔습니다");
        }
    }

    private static void checkIncludeSpecialCharacters(String lottoPurchaseAmount) {
        if (!lottoPurchaseAmount.matches(LOTTO_PURCHASE_AMOUNT_REGEX)) {
            throw new IllegalArgumentException("로또 구입 금액은 숫자로 입력해야 합니다.");
        }
    }

    private static void checkThousandWonUnit(int lottoPurchaseAmount) {
        if (lottoPurchaseAmount % LOTTO_PURCHASE_AMOUNT_UNIT != REMAINDER) {
            throw new IllegalArgumentException(String.format("로또 구입 금액은 %d단위 입니다", LOTTO_PURCHASE_AMOUNT_UNIT));
        }
    }

    private static void checkLottoPurchaseAmountRange(int lottoPurchaseAmount) {
        if (lottoPurchaseAmount <= 0) {
            throw new IllegalArgumentException("로또 구입 금액은 양수로 입력해야 합니다.");
        }
    }
}
