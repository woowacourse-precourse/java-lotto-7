package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        checkNumberRange(numbers);
        checkForDuplicates(numbers);
    }

    private void checkNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void checkForDuplicates(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 포함되어 있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatches(Lotto winningLotto) {
        return (int) numbers.stream().filter(winningLotto.getNumbers()::contains).count();
    }

    public boolean hasBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
