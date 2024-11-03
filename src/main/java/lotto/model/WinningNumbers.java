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
        HashSet<Integer> lottoSet = initializeSet(lotto.getLotto());
        HashSet<Integer> winningNumberSet = initializeSet(numbers);
        getCommonNumber(lottoSet, winningNumberSet);
        return lottoSet.size();
    }

    public boolean containAt(int number) {
        return isContained(number);
    }

    private void getCommonNumber(HashSet<Integer> lottoSet, HashSet<Integer> winningNumberSet) {
        lottoSet.retainAll(winningNumberSet);
    }

    private HashSet<Integer> initializeSet(List<Integer> lotto) {
        return new HashSet<>(lotto);
    }

    private boolean isContained(int number) {
        return numbers.stream()
                .anyMatch(i -> isBonusNumber(number, i));
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
