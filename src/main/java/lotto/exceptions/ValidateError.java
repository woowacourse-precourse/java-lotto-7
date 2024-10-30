package lotto.exceptions;

public class ValidateError {
    private static final String ERROR_HEAD = "[ERROR] ";
    private static final String NO_EXIST_PURCHASE_PRICE = "구입금액을 입력하지 않았습니다.";
    private static final String NO_POSITIVE_PURCHASE_PRICE = "구입금액은 양수여야 합니다.";
    private static final String NO_EXIST_BONUS_NUMBER = "보너스 번호를 입력하지 않았습니다.";
    private static final String NO_EXIST_WINNING_NUMBER = "당첨 번호를 입력하지 않았습니다.";
    private static final String NO_NUMBER_PURCHASE_PRICE = "구입금액은 숫자로 입력하여야 합니다.";
    private static final String NO_NUMBER_BONUS_NUMBER = "보너스 번호는 숫자로 입력하여야 합니다.";
    private static final String NO_NUMBER_WINNING_NUMBER = "당첨 번호는 숫자로 입력하여야 합니다.";
    private static final String INVALID_PURCHASE_PRICE = "구입금액은 1,000원으로 나누어 떨어져야 합니다.";
    private static final String OUT_OF_RANGE_BONUS_NUMBER = "보너스 번호는 1~45 사이의 값이어야 합니다.";
    private static final String OUT_OF_RANGE_WINNING_NUMBER = "당첨 번호는 1~45 사이의 값이어야 합니다.";

    public static int validatePurchasePrice(String purchasePriceStr) {
        if (isBlank(purchasePriceStr)) {
            throw new IllegalArgumentException(ERROR_HEAD + NO_EXIST_PURCHASE_PRICE);
        }
        int purchasePrice;
        try {
            purchasePrice = convertStringToInt(purchasePriceStr);
            if (purchasePrice <= 0) {
                throw new IllegalArgumentException(ERROR_HEAD + NO_POSITIVE_PURCHASE_PRICE);
            }
            if (purchasePrice % 1000 != 0) {
                throw new IllegalArgumentException(ERROR_HEAD + INVALID_PURCHASE_PRICE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_HEAD + NO_NUMBER_PURCHASE_PRICE);
        }
        return purchasePrice / 1000;
    }

    public static int validateWinningNumber(String winningNumberStr) {
        if (isBlank(winningNumberStr)) {
            throw new IllegalArgumentException(ERROR_HEAD + NO_EXIST_WINNING_NUMBER);
        }
        int winningNumber;
        try {
            winningNumber = convertStringToInt(winningNumberStr);
            if (!isInRange(winningNumber)) {
                throw new IllegalArgumentException(ERROR_HEAD + OUT_OF_RANGE_WINNING_NUMBER);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_HEAD + NO_NUMBER_WINNING_NUMBER);
        }
        return winningNumber;
    }

    public static int validateBonusNumber(String bonusNumberStr) {
        if (isBlank(bonusNumberStr)) {
            throw new IllegalArgumentException(ERROR_HEAD + NO_EXIST_BONUS_NUMBER);
        }
        int bonusNumber;
        try {
            bonusNumber = convertStringToInt(bonusNumberStr);
            if (!isInRange(bonusNumber)) {
                throw new IllegalArgumentException(ERROR_HEAD + OUT_OF_RANGE_BONUS_NUMBER);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_HEAD + NO_NUMBER_BONUS_NUMBER);
        }
        return bonusNumber;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean isInRange(int input) {
        return input <= 45 && input >= 1;
    }

    private static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}