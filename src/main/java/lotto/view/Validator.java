package lotto.view;

import java.util.HashSet;
import java.util.List;

public class Validator {

    private static final String ERROR_NOT_DIVISIBLE_BY_1000_MESSAGE = "[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.";
    private static final String ERROR_NOT_NEGATIVE_PURCHASE_NUMBER = "[ERROR] 구입 금액은 양수여야 합니다.";
    private static final String ERROR_COUNT_IS_NOT_6_WINNING_NUMBER_MESSAGE = "[ERROR] 당첨 번호는 총 6개 입력되어야 합니다.";
    private static final String ERROR_OUT_OF_RANGE_WINNING_NUMBER_MESSAGE =
            "[ERROR] 당첨 번호는 1에서 45 사이의 숫자로 이루어져 있어야 합니다.";
    private static final String ERROR_DUPLICATE_WINNING_NUMBER_MESSAGE =
            "[ERROR] 당첨 번호는 중복되지 않은 서로 다른 6개의 숫자가 입력 되어야 합니다.";
    private static final String ERROR_OUT_OF_RANGE_BONUS_NUMBER_MESSAGE =
            "[ERROR] 보너스 번호는 1에서 45 사이의 숫자로 이루어져 있어야 합니다.";
    private static final String ERROR_DUPLICATE_WINNING_NUMBER_AND_BONUS_NUMBER_MESSAGE =
            "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않은 숫자가 입력 되어야 합니다.";

    private static final int PURCHASE_AMOUNT_UNITS = 1000;
    private static final int ZERO = 0;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < ZERO) {
            throw new IllegalArgumentException(ERROR_NOT_NEGATIVE_PURCHASE_NUMBER);
        }
        if (purchaseAmount % PURCHASE_AMOUNT_UNITS != ZERO) {
            throw new IllegalArgumentException(ERROR_NOT_DIVISIBLE_BY_1000_MESSAGE);
        }
    }

    public static void validateWinningNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_COUNT_IS_NOT_6_WINNING_NUMBER_MESSAGE);
        }
        for (int winningNumber : winningNumbers) {
            if (winningNumber < MINIMUM_LOTTO_NUMBER || winningNumber > MAXIMUM_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ERROR_OUT_OF_RANGE_WINNING_NUMBER_MESSAGE);
            }
        }
        if (new HashSet<>(winningNumbers).size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_WINNING_NUMBER_MESSAGE);
        }
    }

    public static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE_BONUS_NUMBER_MESSAGE);
        }
    }

    public static void validateDuplicateWith(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_WINNING_NUMBER_AND_BONUS_NUMBER_MESSAGE);
        }
    }
}
