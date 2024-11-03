package lotto.model.winningNumber;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    //Lotto와 검증로직 겹침, 전환로직과 분리 필요
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateEachNumber(numbers);
    }

    private void validateEachNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (addedDuplicated(number, uniqueNumbers)) {
                throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자를 입력해주세요.");
            }
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1 이상 45 이하의 정수를 입력해주세요.");
            }
        }
    }

    private boolean addedDuplicated(int number, Set<Integer> uniqueNumbers) {
        return !uniqueNumbers.add(number);
    }

    public boolean contains(int number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
