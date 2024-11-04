package lotto.winning.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNumbers {
    private static final String DELIMITER = ",";
    private List<Integer> winningNumbers;
    private ValidatorOfWinningNumber validator;

    public WinningNumbers() {
        validator = ValidatorOfWinningNumber.getValidator();
    }

    public List<Integer> getWinningNumbers(String inputWinningNumbers) {
        splitIntoNumbers(inputWinningNumbers);
        return winningNumbers;
    }

    private void splitIntoNumbers(String inputWinningNumbers) {
        winningNumbers = new ArrayList<>();
        for (String splitedNumber : inputWinningNumbers.split(DELIMITER)) {
            validator.validateCastingToNumber(splitedNumber);
            int number = Integer.parseInt(splitedNumber);

            validator.validateInRange(number);

            validator.validateDegenerate(winningNumbers, number);
            winningNumbers.add(number);
        }
        Collections.sort(winningNumbers);
    }
    

}
