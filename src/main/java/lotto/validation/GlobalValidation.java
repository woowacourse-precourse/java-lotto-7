package lotto.validation;

import static lotto.Constants.LOTTO_MAX_NUM;
import static lotto.Constants.LOTTO_MIN_NUM;
import static lotto.message.ErrorMessage.*;

public class GlobalValidation {

    private static final String NONE_INPUT_STRING = "";
    public static void validateStringToInteger(String input){
        if(!input.chars().allMatch(Character::isDigit) || input.equals(NONE_INPUT_STRING)){
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR.getMessage());
        }
    }

    public static boolean isLottoNumberOutOfRange(int number){
        return number < LOTTO_MIN_NUM || number >= LOTTO_MAX_NUM;
    }


}
