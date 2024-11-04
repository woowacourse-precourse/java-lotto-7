package lotto.domain;

import lotto.util.BonusNumberParser;
import lotto.util.LottoValidator;
import lotto.util.WinningLottoParser;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;
    private final LottoValidator validator;

    public WinningLotto(String input, String bonusNumberInput) {
        List<Integer> parsedNumbers = WinningLottoParser.parseWinningNumbers(input);
        int parsedBonusNumber = BonusNumberParser.toIntStringBonusNumberParser(bonusNumberInput);
        this.validator = new LottoValidator();

        validator.validate(parsedNumbers);
        validator.validateBonusNumber(parsedNumbers, parsedBonusNumber);

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
