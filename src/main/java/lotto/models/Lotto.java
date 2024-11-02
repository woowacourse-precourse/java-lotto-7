package lotto.models;

import lotto.models.constants.LottoValues;
import lotto.validators.constants.ErrorMessages;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoValues.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.INCORRECT_LOTTO_SIZE.getMessage());
        }
        if (numbers.stream().distinct().count() != LottoValues.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_CONTAINS_DUPLICATE.getMessage());
        }
        if (numbers.stream().anyMatch(number -> number > LottoValues.MAX_NUMBER.getValue())) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_NOT_WITHIN_RANGE.getMessage());
        }
        if (numbers.stream().anyMatch(number -> number < LottoValues.MIN_NUMBER.getValue())) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_NOT_WITHIN_RANGE.getMessage());
        }
    }

    public int getMatches(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> matchingNumbers = winningNumbers.stream().filter(this.numbers::contains).toList();
        if (matchingNumbers.size() == 6 || matchingNumbers.size() == 5 && this.numbers.contains(bonusNumber)) {
            return matchingNumbers.size() + 1;
        }
        return matchingNumbers.size();
    }
}
