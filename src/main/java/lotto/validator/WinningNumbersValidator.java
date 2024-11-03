package lotto.validator;

import lotto.controller.WinningNumbersController;
import lotto.util.ErrorMessage;
import lotto.util.LottoNumber;

import java.util.List;

public class WinningNumbersValidator {
    public static void validateBlank(List<String> winningNumbers) {
        try{
            if (winningNumbers.isEmpty()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException err) {
            System.out.println(ErrorMessage.EMPTY_WINNING_NUMBERS_STRING_ERROR);
            WinningNumbersController.restart();
        }
    }
    public static void validateWinningNumbersLength(List<String> winningNumbers) {
        try{
            if (winningNumbers.size() != 6) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException err) {
            System.out.println(ErrorMessage.INVALID_WINNING_NUMBERS_LENGTH_ERROR);
            WinningNumbersController.restart();
        }
    }
    public static void validateElementIsInteger(String token) {
        try{
            Integer.parseInt(token);
        } catch (NumberFormatException err) {
            System.out.println(ErrorMessage.WINNING_NUMBER_NOT_INTEGER_ERROR);
            WinningNumbersController.restart();
        }
    }
    public static void validateElementRange(String token) {
        try{
            int parsedToken = Integer.parseInt(token);
            if (parsedToken < LottoNumber.MIN_LOTTO_NUMBER || parsedToken > LottoNumber.MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException err) {
            System.out.println(ErrorMessage.WINNING_NUMBER_NOT_VALID_RANGE);
            WinningNumbersController.restart();
        }
    }

}
