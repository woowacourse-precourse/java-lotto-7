package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningNumber {
    private final String WINNING_NUMBER_PATTERN = "([1-9][0-9]{0,1},){5}[1-9][0-9]{0,1}";
    private List<Integer> numbers = new ArrayList<>();

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

        if (Arrays.stream(separateWinningNumber).distinct().count() != separateWinningNumber.length) {
            reject();
        }
    }

    public void setNumbers(String input) {
        String[] separateWinningNumber = input.split(",");

        for (int i = 0; i < separateWinningNumber.length; i++) {
            this.numbers.add(Integer.parseInt(separateWinningNumber[i]));
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void reject() {
        throw new IllegalArgumentException();
    }
}
