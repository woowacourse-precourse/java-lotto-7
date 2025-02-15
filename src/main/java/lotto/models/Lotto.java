package lotto.models;

import java.util.HashSet;
import java.util.List;
import static lotto.utils.ErrorMessages.*;
import static lotto.utils.Constants.*;
import static lotto.utils.MessageFormatter.formatErrorMessage;

/*
- Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- numbers의 접근 제어자인 private은 변경할 수 없다.
- Lotto의 패키지를 변경할 수 있다.
*/
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(formatErrorMessage(LOTTO_SHOULD + BE_N_SIZE, LOTTO_SIZE));
        }
        if (new HashSet<>(numbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(formatErrorMessage(LOTTO_SHOULD, NOT_BE_REPEATED));
        }
        for (int number: numbers) {
            if (number < LOTTO_LOWER_BOUND || number > LOTTO_UPPER_BOUND) {
                throw new IllegalArgumentException(formatErrorMessage(LOTTO_SHOULD + BE_IN_RANGE,LOTTO_LOWER_BOUND,LOTTO_UPPER_BOUND));
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
