package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static lotto.enumerate.ErrorPrint.INPUT_HAS_WRONG_PATTERN;
import static lotto.enumerate.ErrorPrint.LOTTO_DOES_NOT_HAVE_CORRECT_SIZE;

public class WinNumber {
    private static final String WIN_NUMBER_DELIMITER = ",";
    private static final String NUMBER_PROVE_DELIMITER = "\\d+";
    private static final Integer SIZE_OF_LOTTO = 6;

    private final List<Integer> numbers;
    private final Integer bonus;

    public WinNumber(String numbers, String bonus) {
        this.numbers = getWinNumbers(numbers);
        this.bonus = getValidatedBonus(bonus);
    }

    private List<Integer> getWinNumbers(String numbers) {
        String[] splitValue = numbers.split(WIN_NUMBER_DELIMITER);
        validateFormats(splitValue);
        validateWinNumber(splitValue);
        return Arrays.stream(splitValue)
                .map(Integer::parseInt)
                .toList();
    }

    private Integer getValidatedBonus(String bonus) {
        validateFormat(bonus);
        return Integer.parseInt(bonus);
    }

    private void validateFormats(String[] inputValues) {
        for (String value : inputValues) {
            validateFormat(value);
        }
    }

    private static void validateFormat(String inputValues) {
        final Pattern PATTERN = Pattern.compile(NUMBER_PROVE_DELIMITER);
        if (!PATTERN.matcher(inputValues).matches()) {
            throw new IllegalArgumentException(INPUT_HAS_WRONG_PATTERN.getMsg());
        }
    }

    private void validateWinNumber(String[] inputValues) {
        if (isNotMatchLottoSize(inputValues)) {
            throw new IllegalArgumentException(LOTTO_DOES_NOT_HAVE_CORRECT_SIZE.getMsg());
        }
    }

    private static boolean isNotMatchLottoSize(String[] inputValues) {
        return inputValues.length != SIZE_OF_LOTTO;
    }

    public int countMatchingNumbers(List<Integer> numbers) {
        int total = 0;
        for (Integer number : numbers) {
            if (isWinNumber(number)) {
                total++;
            }
        }
        return total;
    }

    private boolean isWinNumber(Integer winNumber) {
        return numbers.contains(winNumber);
    }

    public boolean isMatchBonus(List<Integer> numbers) {
        return numbers.contains(bonus);
    }
}
