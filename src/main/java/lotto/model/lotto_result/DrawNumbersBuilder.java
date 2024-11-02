package lotto.model.lotto_result;

import lotto.utils.DrawNumbersValidator;

import java.util.List;

public class DrawNumbersBuilder {

    private final DrawNumbersValidator drawNumbersValidator = new DrawNumbersValidator();
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public DrawNumbersBuilder winningNumbers(String winningNumbers) {
        this.winningNumbers = drawNumbersValidator.validateWinningNumbers(winningNumbers);
        return this;
    }

    public DrawNumbersBuilder bonusNumber(String bonusNumber) {
        this.bonusNumber = drawNumbersValidator.validateBonusNumber(bonusNumber);
        return this;
    }

    public DrawNumbers build() {
        drawNumbersValidator.validateAssociateWinningAndBonusNumbers(winningNumbers, bonusNumber);
        return new DrawNumbers(winningNumbers, bonusNumber);
    }
}
