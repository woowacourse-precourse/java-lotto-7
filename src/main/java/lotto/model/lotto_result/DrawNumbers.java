package lotto.model.lotto_result;

import lotto.utils.DrawNumbersValidator;

import java.util.List;

public class DrawNumbers {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public DrawNumbers(String winningNumbers, String bonusNumber) {
        DrawNumbersValidator drawNumbersValidator = new DrawNumbersValidator();
        this.winningNumbers = drawNumbersValidator.validateWinningNumbers(winningNumbers);
        this.bonusNumber = drawNumbersValidator.validateBonusNumber(bonusNumber);
        drawNumbersValidator.validateAssociateWinningAndBonusNumbers(this.winningNumbers, this.bonusNumber);
    }

    public int countMatch(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public int countBonusNumber(List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }
}