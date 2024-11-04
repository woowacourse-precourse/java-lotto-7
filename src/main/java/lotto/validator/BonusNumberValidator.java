package lotto.validator;

import java.util.Set;
import lotto.message.ErrorMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class BonusNumberValidator {
    public static int validateBonusNumber(String bonusNumber, Set<Integer> winningNumber) {
        checkNullOrEmptyNumber(bonusNumber);
        checkInteger(bonusNumber);
        checkValidBonusNumber(bonusNumber);
        checkDuplicateBonusNumber(bonusNumber, winningNumber);
        return Integer.parseInt(bonusNumber);
    }

    private static void checkNullOrEmptyNumber(String bonusNumber) {
        if (bonusNumber == null || bonusNumber.isBlank()) {
            handleNullOrEmptyNumber();
        }
    }

    private static void handleNullOrEmptyNumber() {
        try {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL_OR_EMPTY.getMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            InputView.inputBonusNumber();
        }
    }

    private static void checkInteger(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
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
            InputView.inputBonusNumber();
        }
    }

    private static void checkValidBonusNumber(String bonusNumber) {
        int bonusNumberInt = Integer.parseInt(bonusNumber);
        if (bonusNumberInt > 45 || bonusNumberInt < 1) {
            handleInvalidBonusNumber();
        }
    }

    private static void handleInvalidBonusNumber() {
        try {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            InputView.inputBonusNumber();
        }
    }

    private static void checkDuplicateBonusNumber(String bonusNumber, Set<Integer> winningNumber) {
        if (winningNumber.contains(Integer.parseInt(bonusNumber))) {
            handleDuplicateWithWinningNumber();
        }
    }

    private static void handleDuplicateWithWinningNumber() {
        try {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            InputView.inputBonusNumber();
        }
    }
}
