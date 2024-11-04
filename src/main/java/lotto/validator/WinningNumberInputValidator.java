package lotto.validator;

public class WinningNumberInputValidator {

    private static final String COMMA = ",";

    public static void validateWinningNumberInput(String input) {
        CommonInputValidator.validateCommonInput(input);
        validateIsIntegerList(input);
    }

    private static void validateIsIntegerList(String input) {
        String[] splitInput = input.split(COMMA);
        for (String s : splitInput) {
            NumberInputValidator.validateNumberInput(s);
        }
    }

}
