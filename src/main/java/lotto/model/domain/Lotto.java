package lotto.model.domain;

import lotto.exception.InputErrorMessage;
import lotto.exception.LottoErrorMessage;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }


    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATED_LOTTO_NUMBERS.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getSize() {
        return numbers.size();
    }
}
