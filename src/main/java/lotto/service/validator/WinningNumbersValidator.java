package lotto.service.validator;

import lotto.util.ErrorMessage;
import lotto.util.LottoNumber;

import java.util.List;

public class WinningNumbersValidator {
    public static boolean validateBlank(List<String> winningNumbers) {
        try{
            if (winningNumbers.isEmpty()) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException err) {
            System.out.println(ErrorMessage.ERROR_EMPTY_WINNING_NUMBERS);
            return false;
        }
    }
    public static boolean validateWinningNumbersLength(List<String> winningNumbers) {
        try{
            if (winningNumbers.size() != 6) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException err) {
            System.out.println(ErrorMessage.ERROR_INVALID_WINNING_NUMBERS_LENGTH);
            return false;
        }
    }
    public static boolean validateElementIsInteger(String token) {
        try{
            Integer.parseInt(token);
            return true;

        } catch (NumberFormatException err) {
            System.out.println(ErrorMessage.ERROR_INVALID_WINNING_NUMBERS_FORMAT);
            return false;
        }
    }
    public static boolean validateElementRange(String token) {
        try{
            int parsedToken = Integer.parseInt(token);
            if (parsedToken < LottoNumber.MIN_LOTTO_NUMBER || parsedToken > LottoNumber.MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException err) {
            System.out.println(ErrorMessage.ERROR_WINNING_NUMBERS_OUT_OF_RANGE);
            return false;
        }
    }
    public static boolean validateDuplicate(List<String> winningNumbers, String token) {
        int count = 0;
        for (String number : winningNumbers) {
            if (number.equals(token)) {
                count++;
            }
        }
        if (count > 1) {
            System.out.println(ErrorMessage.ERROR_DUPLICATE_WINNING_NUMBER);
            return false;
        }
        return true;
    }



}
