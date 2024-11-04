package lotto.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lotto.model.constant.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT);
        }
        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() < numbers.size();
    }

    public Iterator<Integer> getNumbers() {
        return numbers.iterator();
    }

    public LottoResult getMatchedLottoResult(Iterator<Integer> winningNumbers, BonusNumber bonusNumber) {
        int count = 0;
        boolean hasBonusNumber = this.contains(bonusNumber.getNumber());

        while (winningNumbers.hasNext()) {
            if (this.contains(winningNumbers.next())) {
                count++;
            }
        }

        return new LottoResult(count, hasBonusNumber);
    }

    private boolean contains(int number) {
        return numbers.contains(number);
    }
}
