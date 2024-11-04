package lotto.model.draw_numbers;

import java.util.List;

public class DrawNumbers {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public DrawNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int countMatch(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean isMatchBonusNumber(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}