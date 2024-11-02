package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    public static void validateUserMoney(String userInput) {
        if (!isNumeric(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR.getMessage());
        }
        if (!isPositive(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_OR_ZERO_AMOUNT_ERROR.getMessage());
        }
        if (!isDivisibleByThousand(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND_UNIT_ERROR.getMessage());
        }
    }

    public static void validateLotto(List<Integer> lotto) {
        if (!isLottoNumberCountValid(lotto)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT_ERROR.getMessage());
        }
        if (!isLottoNumberRangeValid(lotto)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE_ERROR.getMessage());
        }
        if (!isLottoNumberUnique(lotto)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    public static void validateBonusNumber(List<Integer> winningLotto, String bonusNumberInput) {
        if (!isNumeric(bonusNumberInput)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR.getMessage());
        }
        if (!isValidNumberRange(bonusNumberInput)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE_ERROR.getMessage());
        }
        if (isDuplicateWithWinningLotto(winningLotto, bonusNumberInput)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER_ERROR.getMessage());
        }
    }

    private static boolean isNumeric(String userInput) {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isPositive(String userInput) {
        int amount = Integer.parseInt(userInput);
        return amount > 0;
    }

    private static boolean isDivisibleByThousand(String userInput) {
        int amount = Integer.parseInt(userInput);
        return amount % 1000 == 0;
    }

    private static boolean isLottoNumberCountValid(List<Integer> lottoNumbers) {
        return lottoNumbers.size() == 6;
    }

    private static boolean isValidNumberRange(String numberInput) {
        int number = Integer.parseInt(numberInput);
        return number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX;
    }

    private static boolean isLottoNumberRangeValid(List<Integer> lottoNumbers) {
        for (int number : lottoNumbers) {
            return number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX;
        }
        return true;
    }

    private static boolean isLottoNumberUnique(List<Integer> lottoNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
        return uniqueNumbers.size() == lottoNumbers.size();
    }

    private static boolean isDuplicateWithWinningLotto(List<Integer> winningLotto, String bonusNumberInput) {
        int bonusNumber = Integer.parseInt(bonusNumberInput);

        return winningLotto.contains(bonusNumber);
    }
}
