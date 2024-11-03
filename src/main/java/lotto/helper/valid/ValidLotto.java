package lotto.helper.valid;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.config.exception.lotto.LottoException;
import lotto.config.exception.lotto.LottoExceptionMessage;

public class ValidLotto {
    public static void checkCountNumber(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new LottoException(LottoExceptionMessage.MORE_COUNT_LOTTO_NUMBER);
    }

    public static void checkDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            if (!numberSet.add(number))
                throw new LottoException(LottoExceptionMessage.HAS_DUPLICATE_LOTTO_NUMBER);
        }
    }

    public static void checkRangeNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new LottoException(LottoExceptionMessage.NOT_RANGE_LOTTO_NUMBER);
            }
        }
    }

}
