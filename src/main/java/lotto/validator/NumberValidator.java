package lotto.validator;

import lotto.Lotto;
import lotto.view.OutputView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class NumberValidator {
    private static final String NUMBER_NOT_NUMERIC_MESSAGE = "번호는 숫자만 입력할 수 있습니다.";
    private static final String NUMBER_NOT_IN_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String WINNING_NUMBERS_NOT_DUPLICATE_MESSAGE = "당첨 번호는 중복될 수 없습니다.";

    public static boolean checkValidWinningNumbers(String winningNumbers) throws IllegalArgumentException {
        try {
            winningNumbersAreNumeric(winningNumbers);
            hasSixWinningNumbers(winningNumbers);
            winningNumbersAreInRange(winningNumbers);
            hasDuplicateNumbers(winningNumbers);
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

    private static void numberIsInRange(int inputNumber) throws IllegalArgumentException {
        if (inputNumber < 1 || inputNumber > 45) {
            throw new IllegalArgumentException(NUMBER_NOT_IN_RANGE);
        }
    }

    private static void winningNumbersAreNumeric(String winningNumbers) throws IllegalArgumentException {
            String[] splitWinningNumbers = winningNumbers.split(",");
            for (String winningNumber : splitWinningNumbers) {
                numberIsNumeric(winningNumber);
            }
    }

    private static void hasSixWinningNumbers(String winningNumbers) throws IllegalArgumentException {
        List<Integer> winningNumbersList = Stream.of(winningNumbers.split(","))
                .map(Integer::parseInt)
                .toList();
        new Lotto(winningNumbersList);
    }

    private static void hasDuplicateNumbers(String winningNumbers) throws IllegalArgumentException {
        String[] splitWinningNumbers = winningNumbers.split(",");
        Set<String> uniqueNumbers = new HashSet<>();
        for (String winningNumber : splitWinningNumbers) {
            if (!uniqueNumbers.add(winningNumber)) {
                throw new IllegalArgumentException(WINNING_NUMBERS_NOT_DUPLICATE_MESSAGE);
            }
        }
    }

    private static void winningNumbersAreInRange(String winningNumbers) throws IllegalArgumentException {
        String[] splitWinningNumbers = winningNumbers.split(",");
        for (String winningNumber : splitWinningNumbers) {
            int number = Integer.parseInt(winningNumber);
            numberIsInRange(number);
        }
    }

}
