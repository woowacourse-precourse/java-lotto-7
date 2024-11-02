package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkNumberCount(numbers);
        checkSameNumber(numbers);
        checkNumberRange(numbers);
        this.numbers = numbers;
    }

    private void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void checkSameNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (Collections.frequency(numbers, number) > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다");
            }
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1~45의 정수만 입력하세요.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
