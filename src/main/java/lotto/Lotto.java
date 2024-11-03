package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utilities.Sorter;
import lotto.validation.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.validateLottoNumbers(numbers);
    }

    public String sortedNumbersToString() {
        List<Integer> sortedNumbers = Sorter.inAscendingOrder(numbers);
        return sortedNumbers.toString();
    }

    public int compareWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> setOfWinningNumbers = new HashSet<>(winningNumbers);
        Set<Integer> setOfLottoNumbers = new HashSet<>(numbers);
  
        setOfWinningNumbers.retainAll(setOfLottoNumbers);
        return setOfWinningNumbers.size();
    }

    public boolean compareBonusNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
