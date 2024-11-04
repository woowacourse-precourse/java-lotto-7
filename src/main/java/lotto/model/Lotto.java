package lotto.model;

import lotto.exception.ErrorMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getErrorMessage());
        }
        validateUniqueLottoNumbers(numbers);
        numbers.forEach(this::validateLottoNumber);
    }

    private void validateLottoNumber(Integer lottoNumber) {
        if (lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getErrorMessage());
        }
    }

    private void validateUniqueLottoNumbers(List<Integer> lottoNumbers) {
        Set<Integer> uniqueLottoNumbers = new HashSet<>(lottoNumbers);
        if (uniqueLottoNumbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBERS.getErrorMessage());
        }
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
