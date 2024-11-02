package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputLottoValidator {
    private static final String WINNING_NUMBER_REGEX_PATTERN = "\\d+";

    Lotto lotto;

    public void validate(String winningNumber) {
        getWinningNumber(winningNumber);
    }

    public void validateNumber(String winningNumber) {
        if (Pattern.matches(WINNING_NUMBER_REGEX_PATTERN, winningNumber)) {
            throw new IllegalArgumentException("pattern");
        }
    }

    public List<Integer> getWinningNumber(String winningNumber) {
        validateNumber(winningNumber);
        checkEmpty(winningNumber);
        this.lotto = new Lotto(checkWrongSeparator(winningNumber));
        return checkWrongSeparator(winningNumber);
    }

    public List<Integer> checkWrongSeparator(String winningNumber){
        try {
            return Arrays.stream(winningNumber.split(",")).map(Integer::parseInt).toList();
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("e");
        }
    }

    public void checkEmpty(String winningNumber) {
        if (winningNumber.isEmpty()) {
            throw new IllegalArgumentException("empty");
        }
    }
}
