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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복이 없어야 합니다.");
        }
    }
    public boolean contains(int number) {
        return numbers.contains(number);
    }


    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
    public int matchCount(List<Integer> winnigNumbers) {
        Set<Integer> winningSet = new HashSet<>(winnigNumbers);
        return (int) numbers.stream().filter(winningSet::contains).count();
    }
}
