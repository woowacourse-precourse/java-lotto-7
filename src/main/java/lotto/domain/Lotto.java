package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbersSet = Set.copyOf(numbers);

        if (numbers.size() != uniqueNumbersSet.size()) {
            throw new IllegalArgumentException("당첨 번호가 중복되었습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
