package lotto.model;

import static lotto.common.constants.ExceptionMessages.ERROR_LOTTO_NUMBER_COUNT;
import static lotto.common.constants.ExceptionMessages.ERROR_LOTTO_NUMBER_DUPLICATED;
import static lotto.common.constants.ExceptionMessages.ERROR_LOTTO_NUMBER_RANGE;
import static lotto.common.constants.LottoConstants.LOTTO_RANGE_END;
import static lotto.common.constants.LottoConstants.LOTTO_RANGE_START;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_RANGE_END) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_COUNT.getMessage());
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_DUPLICATED.getMessage());
        }
        if (!isNumberInRange(numbers)) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() < numbers.size();
    }

    private boolean isNumberInRange(List<Integer> numbers) {
        for (Integer number :numbers) {
            if (number < LOTTO_RANGE_START || number > LOTTO_RANGE_END) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer compareWithWinLotto(List<Integer> winLottoNumbers) {
        int matched = 0;
        for (Integer number : numbers) {
            if (winLottoNumbers.contains(number)) {
                matched++;
            }
        }
        return matched;
    }
}
