package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateQuantity(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
        sortNumbers(this.numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateQuantity(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if (number < 0 || number > 6) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
