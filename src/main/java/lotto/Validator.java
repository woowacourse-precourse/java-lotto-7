package lotto;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.ExceptionMessage;
import lotto.exception.IllegalDuplicateException;
import lotto.exception.IllegalNumberCountException;
import lotto.exception.IllegalRangeException;

public class Validator {

    private static final int DUPLICATE_LIMIT_NUMBER = 1;

    public static void validateDuplicate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) > DUPLICATE_LIMIT_NUMBER) {
                throw new IllegalDuplicateException();
            }
        }
    }

    public static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != Lotto.NUMBER_SIZE) {
            throw new IllegalNumberCountException();
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Lotto.NUMBER_BEGIN_RANGE || number > Lotto.NUMBER_END_RANGE) {
                throw new IllegalRangeException();
            }
        }
    }
}
