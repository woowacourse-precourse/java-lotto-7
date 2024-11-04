package lotto.validator;

import java.util.HashSet;
import java.util.Set;
import lotto.message.ErrorMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningNumberValidator {
    public static Set<Integer> validateWinningNumber(String[] winningNumbers) {
        Set<Integer> winningNumberList = new HashSet<>();
        checkWinningNumbersAmount(winningNumbers);
        for (var winningNumber : winningNumbers) {
            checkNullOrEmptyNumber(winningNumber);
            checkInteger(winningNumber);
            checkValidWinningNumber(winningNumber);
            checkDuplicateWinningNumber(winningNumber, winningNumberList);
            winningNumberList.add(Integer.parseInt(winningNumber));
        }
        return winningNumberList;
    }

    private static void checkNullOrEmptyNumber(String winningNumber) {
        if (winningNumber == null || winningNumber.isBlank()) {
            handleNullOrEmptyNumber();
        }
    }

    private static void handleNullOrEmptyNumber() {
        try {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY_WINNING_NUMBER.getMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            InputView.inputWinningNumber();
        }
    }

    private static void checkInteger(String winningNumber) {
        try {
            Integer.parseInt(winningNumber);
        } catch (NumberFormatException e) {
            handleNumberFormatExecption();
        }
    }

    private static void handleNumberFormatExecption(){
        try {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
        catch(IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            InputView.inputWinningNumber();
        }
    }

    private static void checkWinningNumbersAmount(String[] winningNumbers) {
        if (winningNumbers.length != 6) {
            handleInvalidWinningNumbersAmount();
        }
    }

    private static void handleInvalidWinningNumbersAmount() {
        try {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            InputView.inputWinningNumber();
        }
    }

    private static void checkValidWinningNumber(String winningNumber) {
        int winningNumberInt = Integer.parseInt(winningNumber);
        if (winningNumberInt > 45 || winningNumberInt < 1) {
            handleInvalidWinningNumber();
        }
    }

    private static void handleInvalidWinningNumber() {
        try {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER.getMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            InputView.inputWinningNumber();
        }
    }

    private static void checkDuplicateWinningNumber(String winningNumber, Set<Integer> winningNumberList) {
        if (winningNumberList.contains(Integer.parseInt(winningNumber))) {
            handleDuplicateWinningNumber();
        }
    }

    private static void handleDuplicateWinningNumber() {
        try {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            InputView.inputWinningNumber();
        }
    }
}
