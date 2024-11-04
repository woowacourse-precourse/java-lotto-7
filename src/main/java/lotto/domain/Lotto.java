package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> validNumbers = new ArrayList<>(numbers);
        Collections.sort(validNumbers);
        this.numbers = validNumbers;
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

    @Override
    public String toString() {
        return numbers.toString();
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
