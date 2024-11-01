package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.validator.LottoNumberValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public int countMatchingNumbersWithWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        lottoNumbers.retainAll(new HashSet<>(winningNumbers));
        return lottoNumbers.size();
    }

    public boolean isBonusNumberMatched(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

}
