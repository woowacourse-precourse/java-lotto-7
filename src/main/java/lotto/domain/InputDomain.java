package lotto.domain;

import lotto.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputDomain {
    public static List<Integer> convertWinningNumber(String input) {
        String[] tmp = input.split(",");
        List<String> convertedInput = Arrays.asList(tmp);
        List<Integer> convertedResult = new ArrayList<>();

        Validator.validateWinnerSize(convertedInput);

        makeResult(convertedInput, convertedResult);
        Validator.validateWinnerDuplication(convertedResult);

        return convertedResult;
    }

    private static void makeResult(List<String> convertedInput, List<Integer> convertedResult) {
        for (String number : convertedInput) {
            number = number.trim();

            Validator.validateConvertPossibility(number);

            int convertedNumber = Integer.parseInt(number);
            Validator.checkWinnerRange(convertedNumber);

            convertedResult.add(convertedNumber);
        }
    }

    public static int convertBonusNumber(String input) {
        input = input.trim();

        Validator.validateBonusSize(input);
        Validator.validateConvertPossibility(input);

        int convertedResult = Integer.parseInt(input);
        Validator.checkBonusRange(convertedResult);

        return convertedResult;
    }
}
