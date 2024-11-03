package lotto.validator;

import lotto.model.Lotto;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Stream;

public class NumberValidator {
    private static final String NUMBER_NOT_NUMERIC_MESSAGE = "번호는 숫자만 입력할 수 있습니다.";
    private static final String NUMBER_NOT_IN_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

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

    public static boolean checkValidBonusNumber(String bonusNumber) throws IllegalArgumentException {
        try {
            numberIsNumeric(bonusNumber);
            numberIsInRange(bonusNumber);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return false;
        }
        return true;
    }

    private static void numberIsNumeric(String inputNumber) throws IllegalArgumentException {
        if (!inputNumber.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(NUMBER_NOT_NUMERIC_MESSAGE);
        }
    }

    private static void numberIsInRange(String inputNumber) throws IllegalArgumentException {
        if (inputNumber.length() > 7) {
            throw new IllegalArgumentException(NUMBER_NOT_IN_RANGE);
        }
        int number = Integer.parseInt(inputNumber);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(NUMBER_NOT_IN_RANGE);
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
