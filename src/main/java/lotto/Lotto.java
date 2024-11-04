package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> check = new HashSet<>();
        for(Integer number : numbers) {
            if (!check.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 숫자는 중복될 수 없습니다. 중복 번호 : " + number);
            }
        }

        numbers.forEach(this::checkNumberRange);
    }

    private void checkNumberRange(int number) {
        if (!(number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지만 가능합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
