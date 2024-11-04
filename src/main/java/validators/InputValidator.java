package validators;

import static content.ErrorMessage.AGAIN_INPUT_BUY_AMOUNT;
import static content.ErrorMessage.BONUS_NUMBERS_MIN_MAX;
import static content.ErrorMessage.INPUT_BUY_AMOUNT_WRONG;
import static content.ErrorMessage.LOTTO_NUMBERS_DUPLICATION;
import static content.ErrorMessage.LOTTO_NUMBERS_MIN_MAX;
import static content.LottoConstants.LOTTO_COUNT_DIVIDE;
import static content.LottoConstants.LOTTO_MAX_NUMBER;
import static content.LottoConstants.LOTTO_MIN_NUMBER;
import static content.LottoConstants.LOTTO_NUMBERS_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static int validatePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount < LOTTO_COUNT_DIVIDE || amount % LOTTO_COUNT_DIVIDE != 0) {
                throw new IllegalArgumentException(INPUT_BUY_AMOUNT_WRONG.getMessage());
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(AGAIN_INPUT_BUY_AMOUNT.getMessage());
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT || numbers.stream().anyMatch(num -> num < LOTTO_MIN_NUMBER || num > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_MIN_MAX.getMessage());
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATION.getMessage());
        }
    }

    public static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBERS_MIN_MAX.getMessage());
        }
    }
}
