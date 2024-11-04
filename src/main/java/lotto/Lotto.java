package lotto;

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
        for (int i = 0; i < 6; i++) {
            if (numbers.get(i) > 45 || numbers.get(i) < 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1~45 입니다");
            }
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchNumbers(List<Integer> winNumbers) {
        int matchCount = 0;
        for (int number : numbers) {
            if (winNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean hasBonus(int bonusNumber) {
        for (int number : numbers) {
            if (number == bonusNumber) {
                return true;
            }
        }
        return false;
    }
}
