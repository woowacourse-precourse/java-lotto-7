package lotto.domain;

import static lotto.exception.LottoInputException.validateBonusNumber;
import static lotto.exception.LottoInputException.validateLottoNumbers;

import java.util.List;

public class Lotto {
    private static final int BONUS_INDEX = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public void createBonusNumber(int bonusNumber) {
        validateBonusNumber(this.numbers, bonusNumber);
        numbers.add(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return numbers.get(BONUS_INDEX);
    }
}
