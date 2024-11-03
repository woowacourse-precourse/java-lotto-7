package lotto.domain.lottoForm;

import java.util.List;

public class Lotto extends LottoForm {
    private final String DELIMITER = ", ";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validateAndSort(numbers);
    }

    @Override
    public String toString() {
        return String.join(DELIMITER, numbers.toString());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchingNumbers(WinningNumbers winningNumbers) {
        return Math.toIntExact(numbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
