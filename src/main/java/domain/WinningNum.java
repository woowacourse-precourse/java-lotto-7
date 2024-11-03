package domain;

import message.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNum {

    public List<Integer> generateWinningNumbers(String numbers) {

        Validate validate = new Validate();

        List<Integer> winningNumbers = splitInputtedWinningNums(numbers);

        validate.validateIsCountSix(winningNumbers);
        validate.validateIsInRange(winningNumbers);
        validate.validateIsDuplicate(winningNumbers);

        Collections.sort(winningNumbers);
        return winningNumbers;
    }

    public List<Integer> splitInputtedWinningNums(String numbers) {

        Validate validate = new Validate();
        List<Integer> winningNumbers = new ArrayList<>();

        String[] temps = numbers.split(",");

        for(String number : temps) {
            number = number.trim();
            if (number.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.IS_EMPTY.getErrorMessage());
            }
            validate.validateContainsLetters(number);
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }
}
