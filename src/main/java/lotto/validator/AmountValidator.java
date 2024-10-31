package lotto.validator;

import lotto.enums.ExceptionMessage;

import java.util.regex.Pattern;

public class AmountValidator {
    private static final Pattern NUMBERIC_PATTERN = Pattern.compile("^[0-9]*$");
    public void validate(String input) {
        validateNull(input);
        validateNumeric(input);
        validateNonZeroStart(input);
        validateUnit(input);
    }

    private void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_BLANK.getMessage());
        }
    }

    private void validateUnit(String input) {
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_UNIT.getMessage());
        }
    }

    private void validateNonZeroStart(String input){
        if(input.startsWith("0")){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ZERO_START.getMessage());
        }
    }

    private void validateNumeric(String input){
        if(!NUMBERIC_PATTERN.matcher(input).matches()){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NON_NUMERIC.getMessage());
        }
    }
}
