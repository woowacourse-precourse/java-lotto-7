package lotto.validator;

import lotto.enums.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberTypeValidator {

    public List<Integer> validateWinningNumbersType(String userInput) {
        try {
            String[] numbers = userInput.split(",");
            List<Integer> winningNumbers = new ArrayList<>();
            for (String number : numbers) {
                winningNumbers.add(Integer.parseInt(number.trim()));
            }
            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_TYPE_ERROR.toString());
        }
    }

    public int validateBonusNumberType(String userInput) {
        try {
            int bonusNumber = Integer.parseInt(userInput);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_TYPE_ERROR.toString());
        }
    }
}
