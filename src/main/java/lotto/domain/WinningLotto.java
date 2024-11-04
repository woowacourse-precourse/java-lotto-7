package lotto.domain;

import lotto.util.BonusNumberParser;
import lotto.util.WinningLottoParser;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(String input, String bonusNumberInput) {
        List<Integer> parsedNumbers = WinningLottoParser.parseWinningNumbers(input);
        int parsedBonusNumber = BonusNumberParser.toIntStringBonusNumberParser(bonusNumberInput);

        validateNumbers(parsedNumbers);
        validateBonusNumber(parsedNumbers, parsedBonusNumber);

        this.numbers = parsedNumbers;
        this.bonusNumber = parsedBonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


}
