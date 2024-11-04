package lotto.winning.model;

import java.util.List;
import lotto.dto.WinningNumberDto;
import lotto.winning.ValidatorOfWinningNumber;

public class BonusNumber {
    private int bonusNumber;
    private ValidatorOfWinningNumber validator;
    private List<Integer> winningNumbers;

    public BonusNumber() {
        this.validator = ValidatorOfWinningNumber.getValidator();
        winningNumbers = WinningNumberDto.getWinningNumberDto().winningNumbers();
    }

    public int getBonusNumber(String inputBonusNumber) {
        validator.validateCastingToNumber(inputBonusNumber);
        bonusNumber = Integer.parseInt(inputBonusNumber);
        validator.validateInRange(bonusNumber);
        validator.validateDegenerate(winningNumbers, bonusNumber);

        return bonusNumber;
    }


}
