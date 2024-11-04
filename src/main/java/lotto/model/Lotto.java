package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.policy.LottoNumberPolicy;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSixNumber(numbers);
        validateDuplication(numbers);
    }

    private void validateSixNumber(List<Integer> numbers) {
        int scale = LottoNumberPolicy.NUMBER_SCALE.number();
        if (numbers.size() != scale) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
