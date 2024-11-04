package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinNumbers {
    private final List<Integer> numbers;

    public WinNumbers(String[] numbers) {
        this.numbers = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validate();
    }

    private void validate() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }

        for (int number : numbers) { if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        } }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
