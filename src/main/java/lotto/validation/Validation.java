package lotto.validation;

import java.util.HashSet;
import java.util.List;

import static lotto.validation.ErrorMessage.*;

public class Validation {

    public static void checkLottoSize(List<Integer> lottoNumbers, Integer maxLength) {
        if (lottoNumbers.size() > maxLength) {
            throw new IllegalArgumentException(LOTTO_ERROR_WRONG_LOTTO_SIZE.getMessage());
        }
    }

    public static void checkLottoDuplicate(List<Integer> numbers) {
        HashSet<Integer> checkNumber = new HashSet<>(numbers);
        if (checkNumber.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_ERROR_WRONG_LOTTO_DUPLICATE.getMessage());
        }
    }

    public static void checkDuplicateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_ERROR_WRONG_LOTTO_DUPLICATE.getMessage());
        }
    }

}
