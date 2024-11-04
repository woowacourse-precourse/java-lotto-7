
package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int MAX_LOTTO_NUMBER_COUNT = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumbersCount(numbers);
        validateLottoNumbersDuplicated(numbers);
        validateLottoNumbersInRange(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateLottoNumbersCount(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateLottoNumbersDuplicated(List<Integer> numbers) {
        Set<Integer> duplicatedCheck = new HashSet<>(numbers);

        if (duplicatedCheck.size() != MAX_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateLottoNumbersInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            isInRange(number);
        }
    }

    private void isInRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 범위에서 벗어났습니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
