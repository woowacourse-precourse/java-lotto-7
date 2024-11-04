package lotto.validator;

import java.util.Collections;
import java.util.List;

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
            throw new IllegalArgumentException(ErrorMessage.TYPE.getMessage());
        }
    }

    public static void validateNumberRange(Integer number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(ErrorMessage.RANGE.getMessage());
        }
    }

    public static void validateDuplicatedBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATION.getMessage());
        }
    }
}