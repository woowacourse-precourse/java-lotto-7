package lotto.committee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.MessageCenter;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> validSet = new HashSet<>();
        for (Integer number : numbers) {
            validateAdd(validSet, number);
        }
    }

    private void validateAdd(Set<Integer> validSet, Integer number) {
        if (!validSet.add(number)) {
            throw new IllegalArgumentException(MessageCenter.ERROR_NULL.get());
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
