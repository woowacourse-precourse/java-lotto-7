package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final String UNACCEPTED_LENGTH_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private final String DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호 중 중복된 번호가 있습니다.";
    private final String RANGE_OUT_OF_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 1에서 45사이의 숫자로 선택해주세요.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(UNACCEPTED_LENGTH_EXCEPTION_MESSAGE);
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
        numbers.stream().forEach(number -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(RANGE_OUT_OF_EXCEPTION_MESSAGE);
            }
        });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.stream().map(Object::toString).collect(Collectors.joining(", ", "[", "]"));
    }
}
