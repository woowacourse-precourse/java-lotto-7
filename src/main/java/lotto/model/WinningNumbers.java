package lotto.model;

import java.util.HashSet;
import java.util.List;

public class WinningNumbers {

    private final List<Integer> numbers;

    private WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static WinningNumbers of(List<Integer> numbers) {
        return new WinningNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
    }

    public int compareAt(Lotto lotto) {
        HashSet<Integer> lottoSet = new HashSet<>(lotto.getLotto());
        HashSet<Integer> winningNumberSet = new HashSet<>(numbers);
        lottoSet.retainAll(winningNumberSet);
        return lottoSet.size();
    }

    public boolean containAt(int bonusNumber) {
        return numbers.stream()
                .anyMatch(number -> isBonusNumber(bonusNumber, number));
    }

    private boolean isBonusNumber(int bonusNumber, Integer number) {
        return number == bonusNumber;
    }
}
