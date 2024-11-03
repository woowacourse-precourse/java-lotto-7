package lotto.model;

import java.util.List;
import lotto.utilities.Parser;
import lotto.utilities.Splitter;
import lotto.validation.WinningAndBonusNumbersValidator;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public WinningNumbers(String winningNumbers, String bonusNumber) {
        List<String> splittedWinningNumbers = splitWinningNumbers(winningNumbers);
        List<Integer> parseredWinningNumbers = parseWinningNumbers(splittedWinningNumbers);
        Integer parseredBonusNumber = parseBonusNumber(bonusNumber);
        parseredWinningNumbers.add(0, parseredBonusNumber);
        validate(parseredWinningNumbers);
        parseredBonusNumber = parseredWinningNumbers.remove(0);
        this.winningNumbers = parseredWinningNumbers;
        this.bonusNumber = parseredBonusNumber;
    }

    private List<String> splitWinningNumbers(String winningNumbers) {
        return Splitter.splitWinningNumbers(winningNumbers);
    }

    private List<Integer> parseWinningNumbers(List<String> winningNumbers) {
        return Parser.parseNumbersToInt(winningNumbers);
    }

    private Integer parseBonusNumber(String bonusNumber) {
        return Parser.parseNumberToInt(bonusNumber);
    }

    private void validate(List<Integer> winningNumbers) {
        WinningAndBonusNumbersValidator.validateWinningAndBonusNumbers(winningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }
}
