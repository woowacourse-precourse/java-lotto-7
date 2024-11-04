package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 리스트는 null이 될 수 없습니다.");
        }

        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 로또 번호가 중복되지 않는지 확인
    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    // 로또 번호가 1부터 45 사이인지 확인
    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // 두 로또 번호 간의 일치하는 숫자 개수를 세고 반환하는 메서드
    public int countMatchingNumbers(Set<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean contains(int number){
        return numbers.contains(number);
    }
}
