package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateNumber(numbers);
        this.numbers = numbers;
    }

    public int getIndex(int numbers) {
        return this.numbers.indexOf(numbers);
    }

    public boolean matchNumber(int number) {
        return numbers.contains(number);
    }

    public void sort() {
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(number > 0 && number <= 45)) {
                throw new IllegalArgumentException("[ERROR] 번호는 0~45사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (this.matchNumber(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 일치합니다.");
            }
        }
    }

}
