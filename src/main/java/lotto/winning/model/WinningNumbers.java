package lotto.winning.model;

import static lotto.common.constant.LottoConstant.WINNING_NUMBER_DELIMITER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.winning.validator.ValidatorOfWinningNumber;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private final ValidatorOfWinningNumber validator;

    public WinningNumbers() {
        validator = ValidatorOfWinningNumber.getValidator();
    }

    public List<Integer> getWinningNumbers(String inputWinningNumbers) {
        splitIntoNumbers(inputWinningNumbers);
        return winningNumbers;
    }

    private void splitIntoNumbers(String inputWinningNumbers) {
        winningNumbers = new ArrayList<>();
        for (String splitedNumber : inputWinningNumbers.split(WINNING_NUMBER_DELIMITER)) {
            splitedNumber = splitedNumber.trim();
            validator.validateCastingToNumber(splitedNumber);
            int number = Integer.parseInt(splitedNumber);

            validator.validateInRange(number);

            validator.validateDegenerate(winningNumbers, number);
            winningNumbers.add(number);
        }
        validator.validateLottoLimit(winningNumbers);
        Collections.sort(winningNumbers);
    }
}
