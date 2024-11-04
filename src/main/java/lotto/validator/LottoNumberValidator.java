package lotto.validator;

import java.util.List;

import static lotto.validator.ErrorMessage.*;

public class LottoNumberValidator {
    private static final Integer MIN = 1;
    private static final Integer MAX = 45;
    private LottoNumberValidator() {
    }

    public static void validateIntegers(List<String> tokens) {
        for (String token : tokens) {
            validateInteger(token);
        }
    }

    public static void validateInteger(String token) {
        try {
            Integer.parseInt(token);
        }
        catch (Exception e) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + TYPE.getMessage());
        }
    }

    public static void validateNumberRange(Integer number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + RANGE.getMessage());
        }
    }

    public static void validateDuplicatedBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + BONUS_NUMBER_DUPLICATION.getMessage());
        }
    }
}