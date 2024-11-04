package lotto.model;

import lotto.enums.Constants;
import lotto.enums.ExceptionMessage;

import java.util.*;

import static lotto.enums.Constants.MAX_LOTTO_NUM;
import static lotto.enums.Constants.MIN_LOTTO_NUM;
import static lotto.enums.ExceptionMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        List<Integer> newNumbers=sortNumbers(numbers);
        this.numbers = newNumbers;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> newNumbers = new ArrayList<>(numbers);
        Collections.sort(newNumbers);
        return newNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_WINNING_NUMBERS.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> lottoNums= new HashSet<>(numbers);
        if (lottoNums.size()!= 6){
            throw new IllegalArgumentException(INVALID_WINNING_NUM_DUPLICATE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_NUM.getValue() || number > MAX_LOTTO_NUM.getValue()) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUM_RANGE.getMessage());
            }
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
