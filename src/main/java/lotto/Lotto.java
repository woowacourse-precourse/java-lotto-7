package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberContainsNull(numbers);
        validateNumberRange(numbers);
        validateNumbersUnique(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void validateNumberContainsNull(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number == null) {
                throw new IllegalArgumentException("[ERROR] 6개의 당첨 번호를 입력해 주세요.");
            }
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] " + number + ": 1과 45사이의 숫자가 아닙니다.");
            }
        }
    }

    private void validateNumbersUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 6개의 당첨 번호를 입력해 주세요.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return numbers;
    }
}
