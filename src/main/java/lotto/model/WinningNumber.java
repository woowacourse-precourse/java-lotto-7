package lotto.model;

import static lotto.model.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.model.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.model.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.model.LottoErrorConstants.DUPLICATE_NUMBER_ERROR_MESSAGE;
import static lotto.model.LottoErrorConstants.INVALID_NUMBER_COUNT_ERROR_MESSAGE;
import static lotto.model.LottoErrorConstants.INVALID_NUMBER_RANGE_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WinningNumber {

    List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numberList) {
        validateNumberCount(numberList);
        validateNumberRange(numberList);
        validateDuplicateNumber(numberList);
    }

    private void validateNumberCount(List<Integer> numberList) {
        if (numberList.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numberList) {
        for (int number : numberList) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numberList) {
        HashSet<Integer> hashSet = new HashSet<>(numberList);
        if (hashSet.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }

    }

    public int checkSameCount(List<Integer> numbers) {
        List<Integer> copyOfNumbers = new ArrayList<>(numbers);
        copyOfNumbers.retainAll(this.numbers);
        return copyOfNumbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
