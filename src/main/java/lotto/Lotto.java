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
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복이 없어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchingWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        long matchingCount = numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        if (matchingCount == 5 && numbers.contains(bonusNumber)) {
            return -1;
        }
        return (int) matchingCount;
    }


}
