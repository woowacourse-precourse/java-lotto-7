package lotto.util;

import lotto.exception.EmptyInputException;

public class ValidateUtil {

    public static void emptyValue(String value) {
        if(value == null || value.isEmpty()) {
            throw new EmptyInputException();
        }
    }


}
