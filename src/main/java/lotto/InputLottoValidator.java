package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.util.ErrorUtil;

public class InputLottoValidator {
    private static final String WINNING_NUMBER_REGEX_PATTERN = "\\d+";
    private static final String WINNING_NUMBER_SEPARATOR = ",";
    private static final String WINNING_NUMBER_BLANK = " ";

    private void validateNumber(String winningNumber) {
        if (Pattern.matches(WINNING_NUMBER_REGEX_PATTERN, winningNumber)) {
            ErrorUtil.WINNING_LOTTO_NOT_NUMBER_ERROR_MESSAGE.errorException();
        }
    }

    public List<Integer> getWinningNumber(String winningNumber) {
        validateNumber(winningNumber);
        checkEmpty(winningNumber);
        return checkWrongSeparator(winningNumber);
    }

    private List<Integer> checkWrongSeparator(String winningNumber){
        try {
            return Arrays.stream(winningNumber.split(WINNING_NUMBER_SEPARATOR)).map(Integer::parseInt).toList();
        }catch (NumberFormatException e) {
            ErrorUtil.WINNING_LOTTO_COMA_ERROR_MESSAGE.errorException();
        }
        return List.of();
    }

    private void checkEmpty(String winningNumber) {
        if (winningNumber.contains(WINNING_NUMBER_BLANK)) {
            ErrorUtil.WINNING_LOTTO_EMPTY_ERROR_MESSAGE.errorException();
        }
    }
}
