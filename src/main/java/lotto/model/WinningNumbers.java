package lotto.model;

import lotto.exception.LottoGameException;
import lotto.exception.custom.WinningNumberException;

import java.util.HashSet;
import java.util.List;

public class WinningNumbers {

    private final List<Integer> numbers;

    private WinningNumbers(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    public static WinningNumbers of(List<Integer> numbers) {
        return new WinningNumbers(numbers);
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

    private void validateSize(List<Integer> numbers) {
        if (isRightSize(numbers)) {
            throw new LottoGameException(WinningNumberException.INVALID_INPUT);
        }
    }

    private boolean isBonusNumber(int bonusNumber, Integer number) {
        return number == bonusNumber;
    }

    private boolean isRightSize(List<Integer> numbers) {
        return numbers.size() != 6;
    }

}
