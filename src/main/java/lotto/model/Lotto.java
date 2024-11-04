package lotto.model;

import static lotto.model.ErrorMessage.DUPLICATED_LOTTO_NUMBERS;
import static lotto.model.ErrorMessage.INVALID_LOTTO_NUMBERS_COUNT;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;
    
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateNumberCount(numbers);
        hasDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    private void validateNumberCount(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_COUNT.getMessage());
        }
    }

    private void hasDuplicateNumbers(List<LottoNumber> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS.getMessage());
        }
    }
}
