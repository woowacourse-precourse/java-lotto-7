package lotto.validator;

public class LottoPurchaseCostValidator {
    private static final String LOTTO_PURCHASE_COST_REGEX = "^[0-9]+$";
    private static final int LOTTO_PURCHASE_COST_UNIT = 1000;
    private static final int REMAINDER = 0;

    private LottoPurchaseCostValidator() {
    }

    public static void validateLottoPurchaseCost(String lottoPurchaseCost) {
        try {
            int parseValue = Integer.parseInt(lottoPurchaseCost);
            checkThousandWonUnit(parseValue);
            checkLottoPurchaseCostRange(parseValue);
        } catch (NumberFormatException e) {
            checkIncludeSpecialCharacters(lottoPurchaseCost);
            throw new IllegalArgumentException("로또 구입 금액의 값이 자료형의 범위를 넘어갔습니다");
        }
    }

    private static void checkIncludeSpecialCharacters(String lottoPurchaseCost) {
        if (!lottoPurchaseCost.matches(LOTTO_PURCHASE_COST_REGEX)) {
            throw new IllegalArgumentException("로또 구입 금액은 숫자로 입력해야 합니다.");
        }
    }

    private static void checkThousandWonUnit(int lottoPurchaseCost) {
        if (lottoPurchaseCost % LOTTO_PURCHASE_COST_UNIT != REMAINDER) {
            throw new IllegalArgumentException(String.format("로또 구입 금액은 %d단위 입니다", LOTTO_PURCHASE_COST_UNIT));
        }
    }

    private static void checkLottoPurchaseCostRange(int lottoPurchaseCost) {
        if (lottoPurchaseCost <= 0) {
            throw new IllegalArgumentException("로또 구입 금액은 양수로 입력해야 합니다.");
        }
    }
}
