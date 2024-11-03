package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.constants.RandomNumberConstants;
import lotto.enums.ErrorMessage;
import lotto.utilities.Sorter;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumbers(numbers);
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

    public void validateLottoNumbers(List<Integer> lottoNumbers) {
        validateNumbers(lottoNumbers);
        validateDuplicate(lottoNumbers);
    }

    public void validateNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_QUANTITY.getMessage());
        }
        for (Integer number : lottoNumbers) {
            if (number < RandomNumberConstants.MINIMUM_RANDOM_NUMBER
                || number > RandomNumberConstants.MAXIMUM_RANDOM_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
            }
        }
    }

    private  void validateDuplicate(List<Integer> lottoNumbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : lottoNumbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
            }
        }
    }
}
