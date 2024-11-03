package lotto.model;

import lotto.exception.InvalidDuplicateNumberException;
import lotto.exception.InvalidLottoNumberException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new InvalidDuplicateNumberException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }

        for (Integer uniqueNumber : uniqueNumbers) {
            if(uniqueNumber < 1 || uniqueNumber > 45){
                throw new InvalidLottoNumberException("[ERROR] 로또 번호는 1이상 45이하여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
