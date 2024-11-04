package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicationValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void duplicationValidate(List<Integer> numbers) {
        boolean hasDuplicated = numbers.stream()
                .distinct()
                .count() != numbers.size();
        if (hasDuplicated) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 포함되어 있습니다.");
        }

    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public long matchCount(WinningNumber winningNumber) {
        return numbers.stream()
                .filter(winningNumber.getWinningNumbers()::contains)
                .count();
    }

    public boolean containsBonus(WinningNumber winningNumber) {
        return numbers.contains(winningNumber.getBonusNumber());
    }


}
