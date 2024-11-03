package lotto.domain;

import lotto.common.Constant;
import lotto.common.error.CustomException;
import java.util.Arrays;
import lotto.common.error.ErrorMessage;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isNonSize(numbers)) {
            throw new CustomException(ErrorMessage.LOTTO_NUMBERS_SIZE_ERROR_MESSAGE.toString());
        }

        if (isDuplicate(numbers)) {
            throw new CustomException(ErrorMessage.LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE.toString());
        }
    }

    // TODO: 추가 기능 구현
    public Rank getRank(List<Integer> winningNumbers, int bonusNumber) {
        final int matchedCount = getMatchedCount(winningNumbers);
        final boolean isBonus = hasBonusNumber(bonusNumber);
        return Rank.findRank(matchedCount, isBonus);
    }

    private int getMatchedCount(List<Integer> winningNumbers) {
        HashSet<Integer> compareNumbers = new HashSet<>(numbers);
        HashSet<Integer> compareWinning = new HashSet<>(winningNumbers);

        compareNumbers.retainAll(compareWinning);
        return compareNumbers.size();
    }

    private boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private boolean isNonSize(List<Integer> numbers) {
        return numbers.size() != Constant.LOTTO_SIZE;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        HashSet<Integer> duplicate = new HashSet<>(numbers);
        return duplicate.size() < Constant.LOTTO_SIZE;
    }

    @Override
    public String toString() {
        return Arrays.toString(
                numbers.stream().sorted().toArray());
    }
}
