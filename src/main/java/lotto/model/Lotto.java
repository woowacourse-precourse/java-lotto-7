package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

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
        if (!numbers.stream().allMatch(num -> num >= 1 && num <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복이 없어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // 특정 번호가 로또 번호에 포함되어 있는지 확인
    public boolean contains(int number) {
        return numbers.contains(number);
    }

    // 다른 로또와 일치하는 번호의 개수를 반환
    public int matchCount(Lotto other) {
        return (int) numbers.stream()
                .filter(other.getNumbers()::contains)
                .count();
    }
}
