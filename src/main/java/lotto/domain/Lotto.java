package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
        //오름차순(일단 보류)
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 NUMBER가 존재하면 안됩니다.");
        }
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number <= 0 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
