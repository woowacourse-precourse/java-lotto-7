package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int matchCount(WinningNumbers winningNumbers) {
        long matchCount = numbers.stream()
                .filter(winningNumbers.getWinningNumbers()::contains)
                .count();
        return (int) matchCount;
    }

    public boolean hasBonusNumber(WinningNumbers winningNumbers) {
        return numbers.contains(winningNumbers.getBonusNumber());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
