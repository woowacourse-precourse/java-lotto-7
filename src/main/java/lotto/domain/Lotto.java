package lotto.domain;

import lotto.common.ErrorMessages;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> validateCheckNumbers) {
        checkSize(validateCheckNumbers);
        checkDuplicates(validateCheckNumbers);
        checkNumberRange(validateCheckNumbers);
    }

    public void checkSize(List<Integer> checkNumbers){
        if (checkNumbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_COUNT);
        }
    }

    public void checkDuplicates(List<Integer> checkNumbers){
        if (checkNumbers.stream().distinct().count() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_DUPLICATE_NUMBER);
        }
    }

    public void checkNumberRange(List<Integer> checkNumbers){
        for (int number : checkNumbers) {
            if (number < LottoConstants.LOTTO_MIN_NUMBER || number > LottoConstants.LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
            }
        }
    }

    public int countMatches(List<Integer> compareNumbers){
        return (int)numbers.stream()
                .filter(compareNumbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
