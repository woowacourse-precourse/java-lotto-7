package lotto.validator;

import lotto.constant.CompareInteger;
import lotto.constant.WinningNumberRule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumberValidator {

    public static void validateInputComma(String input) throws IllegalArgumentException {
        validateDoubletComma(input);
        validateFirstComma(input);
        validateLastComma(input);
    }

    public static List<Integer> validateInputNumber(List<String> input) throws IllegalArgumentException {
        validateDuplication(input);
        List<Integer> winningNumber = new ArrayList<>();
        for (String separatedInput : input) {
            validateOnlyInteger(separatedInput);
            Integer inputNumber = Integer.parseInt(separatedInput);
            validateNumberScope(inputNumber);
            winningNumber.add(inputNumber);
        }
        return winningNumber;
    }

    private static void validateDoubletComma(String input) throws IllegalArgumentException {
        if (input.contains(WinningNumberRule.COMMA.getMessage() + WinningNumberRule.COMMA.getMessage())) {
            throw new IllegalArgumentException(WinningNumberRule.DOUBLE_COMMA.getMessage());
        }
    }

    private static void validateFirstComma(String input) throws IllegalArgumentException {
        if (input.startsWith(WinningNumberRule.COMMA.getMessage())) {
            throw new IllegalArgumentException(WinningNumberRule.COMMA_FIRST.getMessage());
        }
    }

    private static void validateLastComma(String input) throws IllegalArgumentException {
        if (input.endsWith(WinningNumberRule.COMMA.getMessage())) {
            throw new IllegalArgumentException(WinningNumberRule.COMMA_LAST.getMessage());
        }
    }

    private static void validateDuplication(List<String> input) throws IllegalArgumentException {
        Set<String> deduplication = new HashSet<>(input);
        if (deduplication.size() != input.size()) {
            throw new IllegalArgumentException(WinningNumberRule.DUPLICATION.getMessage());
        }
    }

    private static void validateOnlyInteger(String input) throws IllegalArgumentException {
        if (!input.matches(WinningNumberRule.MATCH_NUMBER.getMessage())) {
            throw new IllegalArgumentException(WinningNumberRule.ONLY_COMMA_INTEGER.getMessage());
        }
    }

    private static void validateNumberScope(Integer number) throws IllegalArgumentException {
        NumberValidator.validateScope(CompareInteger.LOTTO_NUMBER_MINIMUM.getNumber(), CompareInteger.LOTTO_NUMBER_MAXIMUM.getNumber(), number, WinningNumberRule.SCOPE.getMessage());
    }
}
