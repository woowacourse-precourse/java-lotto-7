package lotto.domain;

import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validNumber(numbers);
        this.numbers = orderByASC(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private void validNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException(LottoException.INVALID_LOTTO_NUMBER_RANGE);
            }
        }
    }

    private List<Integer> orderByASC(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }
}
