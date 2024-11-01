package lotto.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BonusNumber {
    private final String BONUS_NUMBER_PATTERN = "[1-9][0-9]{0,1}";

    public void validate(String input) {
        Pattern patternBonusNumber = Pattern.compile(BONUS_NUMBER_PATTERN);
        Matcher matcher = patternBonusNumber.matcher(input);

        if (!matcher.matches()) {
            reject();
        }

        if (!(Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 45)) {
            reject();
        }
    }

    public void reject() {
        throw new IllegalArgumentException();
    }
}
