package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 값이어야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printNumbers() {
        System.out.println("Lotto Numbers: " + numbers);
    }

    public int countMatchingNumbersWithSameObject(Lotto anotherLotto) {
        int count = 0;
        for (int element : anotherLotto.getNumbers()) {
            if (numbers.contains(element)) {
                count++;
            }
        }
        return count;
    }

    public int countMatchingNumbersWithIntegerList(List<Integer> otherNumbers) {
        int count = 0;
        for (int element : otherNumbers) {
            if (numbers.contains(element)) {
                count++;
            }
        }
        return count;
    }
}
