package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int MAX_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateOverlapping(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != MAX_COUNT) {
            String errorMessage = String.format("[ERROR] 로또 번호는 %d개여야 합니다.", MAX_COUNT);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.forEach((number) -> {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                String errorMessage = String.format("[ERROR] 로또 번호는 %d 이상, %d 이하 정수여야 합니다.", MIN_NUMBER, MAX_NUMBER);
                throw new IllegalArgumentException(errorMessage);
            }
        });
    }

    private void validateOverlapping(List<Integer> numbers) {
        Set<Integer> nonOverlappingNumbers = new HashSet<>(numbers);

        if (nonOverlappingNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 중복될 수 없습니다.");
        }
    }

    public List<Integer> getImmutableNumbers() {
        return List.copyOf(numbers);
    }
}
