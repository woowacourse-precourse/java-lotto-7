package lotto.domain;

import lotto.constant.ErrorConstants;
import lotto.constant.UtilConstants;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_LOTTO_COUNT.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        HashSet<Integer> uniqueNumbers = convertToUniqueNumbers(numbers);
        if(uniqueNumbers.size() != UtilConstants.LOTTO_NUMBER_COUNT){
            throw new IllegalArgumentException(ErrorConstants.DUPLICATE_NOT_ALLOWED.getMessage());
        }
    }

    private HashSet<Integer> convertToUniqueNumbers(List<Integer> numbers){
        return new HashSet<>(numbers);
    }
}
