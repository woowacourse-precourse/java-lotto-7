package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputBonusValidator {
    private static final String BONUS_NUMBER_REGEX_PATTERN = "\\d+";

    String bonusNumber;

    public InputBonusValidator(String bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber() {
        if (!Pattern.matches(BONUS_NUMBER_REGEX_PATTERN, bonusNumber)) {
            throw new IllegalArgumentException("[ERROR]pattern");
        }
    }

    public void checkWrongSeparator(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR]b중");
        }
    }

    public int getBonusNumber(List<Integer> winningNumber) {
        validateBonusNumber();
        checkWrongSeparator(winningNumber,Integer.parseInt(bonusNumber));
        return Integer.parseInt(bonusNumber);
    }
}
