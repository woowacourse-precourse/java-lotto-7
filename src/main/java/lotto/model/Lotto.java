package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int countMatchingNumbers(List<Integer> numbersToCompare) {
        int count = 0;
        for (Integer number : numbers) {
            if (numbersToCompare.contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    public boolean containsNumber(int numberToCheck) {
        return numbers.contains(numberToCheck);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
