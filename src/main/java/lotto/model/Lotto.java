package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.utils.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUniqueNumber(numbers);
        this.numbers = numbers;

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_HAVE_SIX_NUMBERS.getMessage());
        }
    }

    private void validateUniqueNumber(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_BE_UNIQUE_NUMBER.getMessage());
        }
    }

    public int matchNumber(List<Integer> numbers) {
        int count = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (this.numbers.contains(numbers.get(i))) {
                count++;
            }
        }

        return count;
    }

    public List<Integer> getNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sort(sortedNumbers);
        return sortedNumbers;
    }

    private void sort(List<Integer> numbers) {
        Collections.sort(numbers);
    }

}
