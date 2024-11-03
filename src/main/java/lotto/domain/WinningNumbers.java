package lotto.domain;

import static lotto.validator.LottoValidator.validateBonusNumber;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.validator.LottoValidator;

public class WinningNumbers {

    private final Set<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        LottoValidator.validateLottoNumbers(numbers);
        validateBonusNumber(bonusNumber, numbers);
        this.numbers = new HashSet<>(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Set<Integer> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
