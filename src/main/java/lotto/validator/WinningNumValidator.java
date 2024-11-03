package lotto.validator;

import static lotto.constant.ExceptionMessage.INVALID_BONUS_CHAR;
import static lotto.constant.ExceptionMessage.INVALID_LOTTO_CHAR;
import static lotto.constant.ExceptionMessage.INVALID_LOTTO_DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumValidator {

    private final static char MIN_NUM_CHAR = '0';
    private final static char MAX_NUM_CHAR = '9';
    private final static String INVALID_NUM_PATTERN = ".*,{2,}.*";

    public List<Integer> validateWinningNum(String winningNum) {
        validateChar(winningNum);
        validateContinuousDelimiter(winningNum);

        return Arrays.stream(winningNum.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void validateBonusNum(String bonusNum) {
        for (char c : bonusNum.toCharArray()) {
            if (c < MIN_NUM_CHAR || c > MAX_NUM_CHAR) {
                throw new IllegalArgumentException(INVALID_BONUS_CHAR.getMessage());
            }
        }
    }

    private void validateChar(String purchasePrice) {
        for (char c : purchasePrice.toCharArray()) {
            if ((c < MIN_NUM_CHAR || c > MAX_NUM_CHAR) && c != ',') {
                throw new IllegalArgumentException(INVALID_LOTTO_CHAR.getMessage());
            }
        }
    }

    private void validateContinuousDelimiter(String winningNum) {
        if (winningNum.matches(INVALID_NUM_PATTERN)) {
            throw new IllegalArgumentException(INVALID_LOTTO_DELIMITER.getMessage());
        }
    }

}
