package lotto.model;

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.Error_Messages;

public class Lotto {
    protected List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        checkDuplicateLottoNumbers(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error_Messages.LOTTO_COUNT_ERROR);
        }
    }

    protected static void checkRange(Integer number){
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException(Error_Messages.NUMBER_RANGE_ERROR);
        }
    }

    private void checkNumbersRange(List<Integer> numbers){
        for (Integer number : numbers) {
            checkRange(number);
        }
    }

    private void checkDuplicateLottoNumbers(List<Integer> numbers){
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(Error_Messages.DUPLICATE_ERROR);
        }
        checkNumbersRange(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}