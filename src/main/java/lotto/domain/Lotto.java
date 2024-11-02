package lotto.domain;

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
    }

    // TODO: 추가 기능 구현
    public void printNumbers() {
        String sortedNumbers = numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println("[" + sortedNumbers + "]");
    }
}
