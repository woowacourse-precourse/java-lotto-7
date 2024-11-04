package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumberDulication(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberDulication(List<Integer> numbers) {
        for (int number : numbers) {
            {
                if (numbers.indexOf(number) != numbers.lastIndexOf(number)) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
                }
            }
        }
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 비어있습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
