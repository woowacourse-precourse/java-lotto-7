package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static lotto.enumerate.ErrorPrint.INPUT_HAS_WRONG_PATTERN;

public class WinNumber {

    private final List<Integer> numbers;
    private final Integer bonus;

    public WinNumber(String numbers, String bonus) {
        this.numbers = getWinNumbers(numbers);
        this.bonus = getValidatedBonus(bonus);
    }

    private List<Integer> getWinNumbers(String numbers) {
        String[] split = numbers.split(",");
        validateFormats(split);
        validateWinNumber(split);
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .toList();
    }

    private Integer getValidatedBonus(String bonus) {
        validateFormat(bonus);
        return Integer.parseInt(bonus);
    }

    private void validateFormats(String[] inputValue) {
        for (String string : inputValue) {
            validateFormat(string);
        }

    }

    private static void validateFormat(String string) {
        final Pattern PATTERN = Pattern.compile("\\d+");
        if (!PATTERN.matcher(string).matches()) {
            throw new IllegalArgumentException(INPUT_HAS_WRONG_PATTERN.getMsg());
        }
    }

    private void validateWinNumber(String[] split) {
        if (split.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개이어야합니다.");
        }
    }

    public int countMatchingNumbers(List<Integer> numbers) {
        int total = 0;
        for (Integer winNumber : numbers) {
            if (isContains(winNumber)) {
                total++;
            }
        }
        return total;
    }

    private boolean isContains(Integer winNumber) {
        return numbers.contains(winNumber);
    }

    public boolean isMatchBonus(List<Integer> numbers) {
        return numbers.contains(bonus);
    }
}
