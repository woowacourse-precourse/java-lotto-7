package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public int countMatching(Lotto other) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return (int) other.numbers.stream()
                .filter(uniqueNumbers::contains)
                .count();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 있으면 안됩니다.");
        }
    }

}
