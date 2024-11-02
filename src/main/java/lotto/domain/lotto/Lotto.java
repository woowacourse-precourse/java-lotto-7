package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateLottoNumberRange(numbers);
        validateDuplication(numbers);

    }

    private void validateNumbersSize(final List<Integer> numbers) {
        if (LottoRule.isSizeRuleViolation(numbers.size())) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateLottoNumberRange(final List<Integer> numbers) {
        for (int number : numbers) {
            if (LottoRule.isRangeRuleViolation(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateDuplication(final List<Integer> numbers) {
        if (LottoRule.isSizeRuleViolation(new HashSet<>(numbers).size())) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

}
