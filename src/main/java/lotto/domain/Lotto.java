package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static lotto.constants.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
    private void validate(List<Integer> numbers) {
        numbersSizeCheck(numbers);
        numbersDuplicateCheck(numbers);
    }

    // TODO: 추가 기능 구현
    private void numbersDuplicateCheck(List<Integer> numbers) {
        if(validateNonDuplicate(numbers)){
            throw new IllegalArgumentException(ERROR_PREFIX.getErrorMessage()
                    .concat(DUPLICATE_LOTTO_NUMBER.getErrorMessage()));
        }
    }
    private static void numbersSizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_PREFIX.getErrorMessage()
                    .concat(INVALID_LOTTO_NUMBER_COUNT.getErrorMessage()));
        }
    }
    private boolean validateNonDuplicate(List<Integer> numbers){
        Set<Integer> distinctNumbers = Set.copyOf(numbers);

        if(distinctNumbers.size() != numbers.size()){
            return true;
        }
        return false;
    }
}