package lotto.domain.ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sort();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void sort() {
        Collections.sort(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int countMatch(Lotto other) {
        int matchCount = 0;
        for (int number : this.numbers) {
            if (other.numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}