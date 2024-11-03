package lotto.vaildate;

import static lotto.eunm.LottoConstants.*;
import static lotto.vaildate.ErrorMessage.*;

import java.util.List;

public class Validate {

    public static int purchasePriceValidate(String price) {
        int purchasePrice = parseIntegerValidate(price);

        if (validPurchasePrice(purchasePrice)) {
            throw new IllegalArgumentException(INPUT_AMOUNT_IN_THOUSANDS);
        }

        return purchasePrice / TICKET_PRICE_UNIT.value;
    }

    public static int parseIntegerValidate(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMERIC_INPUT_ALLOWED);
        }
    }

    public static List<Integer> winningNumbersValidate(List<Integer> winningNumbers) {
        validateWinningNumberCount(winningNumbers);
        validateNumberInRange(winningNumbers);
        validateUniqueNumber(winningNumbers);
        return winningNumbers;
    }

    public static int parseIntegerBonusValidate(String value, List<Integer> winningNumbers) {
        int parsedValue = parseIntegerValidate(value);
        validateBonusNumber(parsedValue);
        bonusNumberDuplicateValidate(winningNumbers, parsedValue);
        return parsedValue;
    }

    private static boolean validPurchasePrice(int purchasePrice) {
        return (purchasePrice % TICKET_PRICE_UNIT.value) != MINIMUM_NUMBER.value || purchasePrice < MINIMUM_NUMBER.value;
    }

    private static void validateWinningNumberCount(List<Integer> validNumbers) {
        if (validNumbers.size() != LOTTO_NUMBERS_COUNT.value) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT);
        }
    }

    private static void validateUniqueNumber(List<Integer> winningNumbers) {
        if (winningNumbers.stream().distinct().count() != LOTTO_NUMBERS_COUNT.value) {
            throw new IllegalArgumentException(UNIQUE_NUMBER);
        }
    }

    private static void validateNumberInRange(List<Integer> winningNumbers) {
        if (numberIsRange(winningNumbers)) {
            throw new IllegalArgumentException(NUMBER_ONE_TO_FORTY_FIVE);
        }
    }

    private static boolean numberIsRange(List<Integer> winningNumbers) {
        return winningNumbers.stream().anyMatch(Validate::isLottoRange);
    }

    private static boolean isLottoRange(Integer number) {
        return number < MINIMUM_NUMBER.value || number > MAX_LOTTO_NUMBER.value;
    }

    private static void validateBonusNumber(int number) {
        if (isLottoRange(number)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER);
        }
    }

    private static void bonusNumberDuplicateValidate(List<Integer> winningNumbers, int bonusValidate) {
        if (winningNumbers.contains(bonusValidate)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER);
        }
    }

}
