package lotto.validation;


import lotto.utils.Utils;

import static lotto.message.ErrorMessage.*;

public class GlobalValidation {

    private static final String NONE_INPUT_STRING = "";
    public static void validateStringToInteger(String input){
        if(!input.chars().allMatch(Character::isDigit) || input.equals(NONE_INPUT_STRING)){
            Utils.print(NOT_NUMERIC_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

}
