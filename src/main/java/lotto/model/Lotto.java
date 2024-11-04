package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        List<Integer> visitedNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (visitedNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될수 없습니다.");
            }
            visitedNumbers.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
