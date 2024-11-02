package lotto.util;

import lotto.exception.ErrorMessage;
import lotto.exception.ExceptionHandler;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoValueUtil {

    private final static String DELIMITER = ",";

    public static int toLottoAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount >= 1000 && amount % 1000 == 0) {
                return amount;
            }
            throw new IllegalArgumentException();
        } catch (NumberFormatException e) {
            ExceptionHandler.inputException(ErrorMessage.INVALID_AMOUNT);
        } catch (IllegalArgumentException e) {
            ExceptionHandler.inputException(ErrorMessage.INVALID_AMOUNT);
        }
        throw new IllegalArgumentException("[ERROR] 처리 중 오류가 발생했습니다.");
    }

    public static Set<Integer> toWinningNumbers(String input) {
        try {
            Set<Integer> winningNumbers = Arrays.stream(input.split(DELIMITER))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .peek(LottoValueUtil::validLottoNumberRange)
                    .boxed()
                    .collect(Collectors.toSet());
            if (winningNumbers.size() == 6) {
                return winningNumbers;
            }
            throw new IllegalArgumentException();
        } catch (NumberFormatException e) {
            ExceptionHandler.inputException(ErrorMessage.INVALID_LOTTO_NUMBER);
        } catch (IllegalArgumentException e) {
            ExceptionHandler.inputException(ErrorMessage.INVALID_LOTTO_NUMBER);
        }
        throw new IllegalArgumentException("[ERROR]: 처리 중 오류가 발생했습니다.");
    }

    public static int toBonusNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            validLottoNumberRange(number);
            return number;
        } catch (NumberFormatException e) {
            ExceptionHandler.inputException(ErrorMessage.INVALID_LOTTO_NUMBER);
        } catch (IllegalArgumentException e) {
            ExceptionHandler.inputException(ErrorMessage.INVALID_LOTTO_NUMBER);
        }
        throw new IllegalArgumentException("[ERROR]: 처리 중 오류가 발생했습니다.");
    }

    private static void validLottoNumberRange(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException();
        }
    }
}
