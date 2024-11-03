package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int SIZE_OF_LOTTO = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int getMatchNumbersCount(WinningNumbers winningNumbers) {
        return (int) numbers.stream()
                .filter(number -> winningNumbers.getReceivedLottoNumbers().contains(number))
                .count();
    }

    public boolean hasBonus(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getBonusNumber());
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkRange(numbers);
        checkDuplicate(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != SIZE_OF_LOTTO) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBERS.getMessage());
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.getMessage());
            }
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
