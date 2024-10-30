package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("[ERROR] " + "로또 번호가 null이어서는 안 됩니다.");
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (isDuplicateExisted(numbers)) {
            throw new IllegalArgumentException("[ERROR] " + "로또 번호는 중복되지 않아야 합니다.");
        }
        if (isNotInRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] " + "로또 번호는 1에서 45사이여야 합니다.");
        }
    }

    private boolean isDuplicateExisted(List<Integer> numbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);
        return noDuplicateNumbers.size() != numbers.size();
    }

    private boolean isNotInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return true;
            }
        }
        return false;
    }
}
