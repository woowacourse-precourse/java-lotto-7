package lotto.domain;

import static lotto.utils.Constant.MAX_LOTTO_NUMBER_COUNT;
import static lotto.utils.ErrorMessage.LOTTO_NUMBER_ERROR_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int countMatchNumbers(List<Integer> winningNumbers) {
        int matchCount = 0;

        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE.toString());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE.toString());
        }
    }

    public boolean isMatchBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
