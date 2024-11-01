package common.view.input;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public int toPositive(String input) {
        int number = toInteger(input);
        validateNegative(number);
        return number;
    }

    public List<Integer> toLottoNumbers(String input) {
        return Arrays.stream(split(input))
                .map(this::toLottoNumber)
                .toList();
    }

    public int toLottoNumber(String input) {
        int number = toPositive(input);
        validateRange(number);
        return number;
    }

    private String[] split(String input) {
        return input.split(",");
    }

    private int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNegative(int number) {
        if (isNegative(number)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(int n) {
        if (isLottoRange(n)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNegative(int number) {
        return number > 0;
    }

    private boolean isLottoRange(int n) {
        return n < 0 || n > 45;
    }

}
