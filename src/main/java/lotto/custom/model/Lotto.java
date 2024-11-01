package lotto.custom.model; // Lotto의 패키지를 변경할 수 있다.

import java.util.List;

public class Lotto {
    private final List<Integer> numbers; // numbers의 접근 제어자인 private은 변경할 수 없다.

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateUniqueNumbers(numbers);
        validateNumberRange(numbers);
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
    
    public List<Integer> getNumbers() {
        return numbers;
    }
}