package lotto.utils;

import java.util.List;
import lotto.validation.NumberRangeValidator;
import lotto.validation.UniqueNumberValidator;
import lotto.validation.Validator;

public class ValidatorFactory {
    public static Validator<Integer> createNumberRangeValidator(int min, int max, String errorMessage) {
        return new NumberRangeValidator(min, max, errorMessage);
    }

    public static Validator<List<Integer>> createUniqueNumberValidator(String errorMessage) {
        return new UniqueNumberValidator(errorMessage);
    }
}
