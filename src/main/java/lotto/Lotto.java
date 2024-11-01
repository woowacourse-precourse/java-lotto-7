package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.sort;

public class Lotto {
    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_MAXIMUM_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
        sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> lotto = new HashSet<>(numbers);
        if (lotto.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다");
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isInvalid = numbers.stream().anyMatch(num -> num < LOTTO_MINIMUM_NUMBER || num > LOTTO_MAXIMUM_NUMBER);
        if (isInvalid) {
            throw new IllegalArgumentException("[ERROR] 숫자는 1부터 45 사이여야 합니다.");
        }
    }


}
