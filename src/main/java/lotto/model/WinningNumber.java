package lotto.model;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningNumber {
    private final String WINNING_NUMBER_PATTERN = "([1-9][0-9]{0,1},){5}[1-9][0-9]{0,1}";

    public void validate(String input) {
        Pattern patternWinningNumber = Pattern.compile(WINNING_NUMBER_PATTERN);
        Matcher matcherPay = patternWinningNumber.matcher(input);

        if (!matcherPay.matches()) {
            reject();
        }

        String[] separateWinningNumber = input.split(",");
        if (!Arrays.stream(separateWinningNumber)
                .allMatch(num -> Integer.parseInt(num) >= 1 && Integer.parseInt(num) <= 45)) {
            reject();
        }
    }

    public void reject() {
        throw new IllegalArgumentException();
    }
}
