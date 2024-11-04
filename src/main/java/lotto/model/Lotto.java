package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.Exception;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateUnique(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Jackpot.getSizeLimit()) {
            Exception.getInvalidSize();
        }
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (uniqueNumbers.contains(number)) {
                Exception.getInvalidUnique();
            }
            uniqueNumbers.add(number);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Jackpot.getMinNumber()) {
                Exception.getInvalidRange();
            }
            if (number > Jackpot.getMaxNumber()) {
                Exception.getInvalidRange();
            }
        }
    }
    
    public List<Integer> getNumbers() {
        return numbers;
    }
}