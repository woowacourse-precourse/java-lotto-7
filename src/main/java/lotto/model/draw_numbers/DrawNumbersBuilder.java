package lotto.model.draw_numbers;

import lotto.utils.DrawNumbersValidator;

import java.util.List;

public class DrawNumbersBuilder {

    private List<Integer> winningNumbers;
    private int bonusNumber;
    private final DrawNumbersValidator drawNumbersValidator = new DrawNumbersValidator();

    public DrawNumbersBuilder winningNumbers(String rawWinningNumbers) {
        this.winningNumbers = drawNumbersValidator.validateWinningNumbers(rawWinningNumbers);
        return this;
    }

    public DrawNumbersBuilder bonusNumber(String rawBonusNumber) {
        this.bonusNumber = drawNumbersValidator.validateBonusNumber(rawBonusNumber);
        drawNumbersValidator.validateAssociateWinningAndBonusNumbers(winningNumbers, bonusNumber);
        return this;
    }

    public DrawNumbers build() {
        return new DrawNumbers(winningNumbers, bonusNumber);
    }
}
