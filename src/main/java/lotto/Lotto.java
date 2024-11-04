package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkNumbers(numbers);
        checkDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void checkNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void checkDuplicates(List<Integer> numbers) {
        List<Integer> checkNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (checkNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 앞의 숫자와 중복되지 않는 새로운 숫자를 입력하세요.");
            }
            checkNumbers.add(number);
        }
    }
}
