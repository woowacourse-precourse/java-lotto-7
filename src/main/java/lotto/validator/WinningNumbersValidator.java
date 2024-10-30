package lotto.validator;

import lotto.common.CommonValidator;
import lotto.common.ErrorMessage;
import lotto.common.RegexPattern;

import java.util.Arrays;

public class WinningNumbersValidator {
    private static final String INPUT_SEPERATOR=",";

    public static void validateWinningNumbers(String input){
        CommonValidator.validateNullAndBlank(input);
        validateOnyIntegerAndComma(input);

        int[] winningNumbers= Arrays.stream(input.split(INPUT_SEPERATOR))
                        .mapToInt(Integer::parseInt)
                                .toArray();
    }

    private static void validateOnyIntegerAndComma(String input) {
        if (!RegexPattern.ONLY_INTEGER_AND_COMMA.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_CHARACTER);
        }
    }

}
