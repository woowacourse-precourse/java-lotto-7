package lotto.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static lotto.validation.ErrorMessage.*;

public class Validation {

    public void checkLottoSize(List<Integer> numbers) {
        if (numbers.size() > 6) {
            throw new IllegalArgumentException(LOTTO_ERROR_WRONG_LOTTO_SIZE.getMessage());
        }
    }

    public void checkLottoDuplicate(List<Integer> numbers, Integer bonusNumber) {

        HashSet<Integer> checkNumber = new HashSet<>();

        numbers.stream()
                .filter(num -> !checkNumber.add(num))
                .findFirst()
                .ifPresent(duplicate -> {
                    throw new IllegalArgumentException(LOTTO_ERROR_WRONG_LOTTO_DUPLICATE.getMessage());
                });

        checkDuplicateBonusNumber(bonusNumber, checkNumber);
    }

    private void checkDuplicateBonusNumber(Integer bonusNumber, HashSet<Integer> checkNumber) {
        if (bonusNumber != null) {
            if (checkNumber.contains(bonusNumber)) {
                throw new IllegalArgumentException(LOTTO_ERROR_WRONG_LOTTO_DUPLICATE.getMessage());
            }
        }
    }

}
