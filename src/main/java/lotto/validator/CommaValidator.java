package lotto.validator;

import static lotto.constant.ErrorCode.CONTIGIOUS_COMMA;

public class CommaValidator {

    private static final String COMMAS = ",,";

    public static void validate(String input) {
        if (input.contains(COMMAS)) {
            throw new IllegalArgumentException(CONTIGIOUS_COMMA.getMessage());
        }
    }
}