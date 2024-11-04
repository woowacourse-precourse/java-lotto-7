package lotto;

import lotto.domain.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            LottoNumber.of(number);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
