package lotto.validator;

import static lotto.constant.ExceptionMessage.INVALID_BONUS_CHAR;
import static lotto.constant.ExceptionMessage.INVALID_BONUS_RANGE;
import static lotto.constant.ExceptionMessage.INVALID_LOTTO_CHAR;
import static lotto.constant.ExceptionMessage.INVALID_LOTTO_DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumValidator {

    private final static char MIN_NUM_CHAR = '0';
    private final static char MAX_NUM_CHAR = '9';
    private final static int MIN_LOTTO_NUM = 1;
    private final static int MAX_LOTTO_NUM = 45;
    private final static String INVALID_NUM_PATTERN = ".*,{2,}.*";
    private final static char DELIMITER = ',';

    public List<Integer> validateWinningNum(String winningNum) {
        validateChar(winningNum);
        validateDelimiter(winningNum);

        return Arrays.stream(winningNum.split(String.valueOf(DELIMITER)))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void validateBonusNum(String bonusNum) {
        validateNum(bonusNum);
        validateRange(bonusNum);
    }

    private void validateChar(String input) {
        for (char c : input.toCharArray()) {
            if ((c < MIN_NUM_CHAR || c > MAX_NUM_CHAR) && c != DELIMITER) {
                throw new IllegalArgumentException(INVALID_LOTTO_CHAR.getMessage());
            }
        }
    }

    private void validateDelimiter(String input) {
        if (input.matches(INVALID_NUM_PATTERN) || input.endsWith(String.valueOf(DELIMITER))) {
            throw new IllegalArgumentException(INVALID_LOTTO_DELIMITER.getMessage());
        }
    }

    private static void validateNum(String bonusNum) {
        for (char c : bonusNum.toCharArray()) {
            if (c < MIN_NUM_CHAR || c > MAX_NUM_CHAR) {
                throw new IllegalArgumentException(INVALID_BONUS_CHAR.getMessage());
            }
        }
    }

    private void validateRange(String input) {
        if (Integer.parseInt(input) < MIN_LOTTO_NUM || Integer.parseInt(input) > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(INVALID_BONUS_RANGE.getMessage());
        }
    }

}
