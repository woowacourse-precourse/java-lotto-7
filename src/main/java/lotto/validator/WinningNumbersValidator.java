package lotto.validator;

import lotto.common.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersValidator {
    private static final String INPUT_SEPERATOR=",";

    public static List<Integer> validateWinningNumbers(String input){
        validateNullAndBlank(input);
        List<Integer> parsedWinningNumbers=validateOnyIntegerAndComma(input);

        return parsedWinningNumbers;
    }

    private static List<Integer> validateOnyIntegerAndComma(String input) {
        try{
            return Arrays.stream(input.split(INPUT_SEPERATOR))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE);
        }
    }

    private static void validateNullAndBlank(String input) {
        if (input==null || input.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.BLANK_OR_NULL_INPUT);
        }
    }
}
