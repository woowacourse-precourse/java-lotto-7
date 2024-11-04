package lotto.validator;

import lotto.model.Lotto;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Stream;

import static lotto.model.constants.NumberValidatorConstans.*;

public class NumberValidator {

    public static boolean checkValidWinningNumbers(String winningNumbers) throws IllegalArgumentException {
        try {
            winningNumbersAreNumeric(winningNumbers);
            isValidToLotto(winningNumbers);
            winningNumbersAreInRange(winningNumbers);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean checkValidBonusNumber(String bonusNumber, List<Integer> winningNumbers) throws IllegalArgumentException {
        try {
            numberIsNumeric(bonusNumber);
            numberIsInRange(bonusNumber);
            isNotWinningNumber(bonusNumber, winningNumbers);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return false;
        }
        return true;
    }

    private static void isNotWinningNumber(String inputNumber, List<Integer> winningNumbers) throws IllegalArgumentException {
        int bonusNumber = Integer.parseInt(inputNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_WINNING_NUMBER.getMessage());
        }
    }

    private static void numberIsNumeric(String inputNumber) throws IllegalArgumentException {
        if (!inputNumber.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(NUMBER_NOT_NUMERIC_MESSAGE.getMessage());
        }
    }

    private static void numberIsInRange(String inputNumber) throws IllegalArgumentException {
        if (inputNumber.length() > 7) {
            throw new IllegalArgumentException(NUMBER_NOT_IN_RANGE.getMessage());
        }
        int number = Integer.parseInt(inputNumber);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(NUMBER_NOT_IN_RANGE.getMessage());
        }
    }

    private static void winningNumbersAreNumeric(String winningNumbers) throws IllegalArgumentException {
            String[] splitWinningNumbers = winningNumbers.split(",");
            for (String winningNumber : splitWinningNumbers) {
                numberIsNumeric(winningNumber);
            }
    }

    private static void isValidToLotto(String winningNumbers) throws IllegalArgumentException {
        List<Integer> winningNumbersList = Stream.of(winningNumbers.split(","))
                .map(Integer::parseInt)
                .toList();
        new Lotto(winningNumbersList);
    }

    private static void winningNumbersAreInRange(String winningNumbers) throws IllegalArgumentException {
        String[] splitWinningNumbers = winningNumbers.split(",");
        for (String winningNumber : splitWinningNumbers) {
            numberIsInRange(winningNumber);
        }
    }

}
