package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.ConstantMessage.ErrorMessage;

public class Validator {
    public void validateLottoNumber(int value) {
        if (value < ConstantValue.LOTTO_MIN_VALUE || value > ConstantValue.LOTTO_MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_RANGE.getMessage());
        }
    }

    public void validateLottoNumber(List<Integer> values) {
        Set<Integer> uniqueValues = new HashSet<>(values);
        if (values.size() != ConstantValue.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT.getMessage());
        }
        if (uniqueValues.size() != ConstantValue.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_VALUE.getMessage());
        }
        values.forEach(this::validateLottoNumber);
    }

    public <T> void validateDuplicated(List<T> values, T value) {
        if (values.contains(value)) {
            throw new IllegalStateException(ErrorMessage.DUPLICATED_LOTTO_VALUE.getMessage());
        }
    }

    public void validatePrice(int value) {
        if (value <= 0 || value % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
