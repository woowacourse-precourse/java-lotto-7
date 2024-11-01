package lotto.model;

import static lotto.constants.ErrorMessage.DUPLICATE_NUMBER_MESSAGE;
import static lotto.constants.ErrorMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.constants.ErrorMessage.INPUT_LOTTO_NUMBER_OUT_OF_RANGE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.dto.LottoNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Comparator.naturalOrder());
    }

    public LottoNumbers getLottoNumbers() {
        return new LottoNumbers(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException(INPUT_LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);

        if (nonDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
    }

}
