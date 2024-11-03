package lotto.exceptions;

import lotto.model.Lotto;
import lotto.service.ParsingWinningNumberService;

public class ValidateError {
    public enum ErrorCode {
        DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호가 중복되면 안됩니다."),
        NO_EXIST_PURCHASE_PRICE("[ERROR] 구입금액을 입력하지 않았습니다."),
        NO_POSITIVE_PURCHASE_PRICE("[ERROR] 구입금액은 양수여야 합니다."),
        NO_EXIST_BONUS_NUMBER("[ERROR] 보너스 번호를 입력하지 않았습니다."),
        NO_EXIST_WINNING_NUMBER("[ERROR] 당첨 번호를 입력하지 않았습니다."),
        NO_NUMBER_PURCHASE_PRICE("[ERROR] 구입금액은 숫자로 입력하여야 합니다."),
        NO_NUMBER_BONUS_NUMBER("[ERROR] 보너스 번호는 숫자로 입력하여야 합니다."),
        NO_NUMBER_WINNING_NUMBER("[ERROR] 당첨 번호는 숫자로 입력하여야 합니다."),
        INVALID_PURCHASE_PRICE("[ERROR] 구입금액은 1,000원으로 나누어 떨어져야 합니다."),
        OUT_OF_RANGE_BONUS_NUMBER("[ERROR] 보너스 번호는 1~45 사이의 값이어야 합니다."),
        OUT_OF_RANGE_WINNING_NUMBER("[ERROR] 당첨 번호는 1~45 사이의 값이어야 합니다.");

        private final String message;

        ErrorCode(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static int validatePurchasePrice(String purchasePriceStr) {
        if (isBlank(purchasePriceStr)) {
            throw new IllegalArgumentException(ErrorCode.NO_EXIST_PURCHASE_PRICE.getMessage());
        }
        int purchasePrice;
        try {
            purchasePrice = convertStringToInt(purchasePriceStr);
            if (purchasePrice <= 0) {
                throw new IllegalArgumentException(ErrorCode.NO_POSITIVE_PURCHASE_PRICE.getMessage());
            }
            if (purchasePrice % 1000 != 0) {
                throw new IllegalArgumentException(ErrorCode.INVALID_PURCHASE_PRICE.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.NO_NUMBER_PURCHASE_PRICE.getMessage());
        }
        return purchasePrice;
    }

    public static Lotto validateWinningNumber(String winningNumberStr) {
        if (isBlank(winningNumberStr)) {
            throw new IllegalArgumentException(ErrorCode.NO_EXIST_WINNING_NUMBER.getMessage());
        }
        Lotto winningNumbers;
        try {
            winningNumbers = ParsingWinningNumberService.parseWinningNumbers(winningNumberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.NO_NUMBER_WINNING_NUMBER.getMessage());
        }
        for (int number : winningNumbers.getNumbers()) {
            if (!isInRange(number)) {
                throw new IllegalArgumentException(ErrorCode.OUT_OF_RANGE_WINNING_NUMBER.getMessage());
            }
        }
        return winningNumbers;
    }

    public static int validateBonusNumber(String bonusNumberStr) {
        if (isBlank(bonusNumberStr)) {
            throw new IllegalArgumentException(ErrorCode.NO_EXIST_BONUS_NUMBER.getMessage());
        }
        int bonusNumber;
        try {
            bonusNumber = convertStringToInt(bonusNumberStr);
            if (!isInRange(bonusNumber)) {
                throw new IllegalArgumentException(ErrorCode.OUT_OF_RANGE_BONUS_NUMBER.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.NO_NUMBER_BONUS_NUMBER.getMessage());
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
