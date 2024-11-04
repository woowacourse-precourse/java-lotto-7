package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.error.lotto.LottoErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (set.contains(number)) {
                throw new IllegalArgumentException(LottoErrorMessage.INPUT_DATA_IS_NOT_PATTERN);
            }
            set.add(number);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
