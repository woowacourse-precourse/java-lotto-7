package lotto.common.validator;

import static lotto.common.ExceptionMessage.INVALID_DUPLICATE_LOTTO_NUMBER;
import static lotto.common.ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.common.ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.common.LottoConfig;

public class LottoValidator {
    public static void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_PICK_COUNT.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
        if (!isValidLottoNumberRange(numbers)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
        if (!isLottoNumberNotDuplicated(numbers)) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private static boolean isValidLottoNumberRange(List<Integer> numbers) {
        return numbers.stream()
                .filter(lottoNumber -> lottoNumber >= LottoConfig.LOTTO_MIN_NUMBER.getValue()
                        && lottoNumber <= LottoConfig.LOTTO_MAX_NUMBER.getValue()
                ).collect(Collectors.toList()).size() == numbers.size();
    }

    private static boolean isLottoNumberNotDuplicated(List<Integer> numbers) {
        return Set.copyOf(numbers).size() == LottoConfig.LOTTO_PICK_COUNT.getValue();
    }
}
