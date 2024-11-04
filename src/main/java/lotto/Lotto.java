package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumber(numbers);
        validateRepeat(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRepeat(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호가 중복되면 안됩니다.");
            }
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45중 양수여야 합니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getLottoNumber() {
        return numbers;
    }
}
