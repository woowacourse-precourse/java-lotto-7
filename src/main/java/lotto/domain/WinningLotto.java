package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(String winningNumbersInput, String bonusNumberInput) {
        this.numbers = Validator.validateAndParseWinningNumbers(winningNumbersInput);
        this.bonusNumber = Validator.validateAndParseBonusNumber(bonusNumberInput, numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
