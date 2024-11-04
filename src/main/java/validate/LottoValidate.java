package validate;

import lotto.Lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoValidate {
    private static final String OUT_OF_RANGE_LOTTO_NUMBER_ERR = "[ERROR] out of range lotto number";
    private static final String STRANGE_INPUT_VALUES_ERR = "[ERROR] strange input value";
    private static final String ALPHABET_REGEX = "[a-zA-Z]";

    public static void validateOnlyNumberWithSpecialChar(String input, String numberRegex, String specialCharRegex){
        String regex = "^[" + numberRegex + specialCharRegex + "]+$";
        if(!input.matches(regex))
            throw new IllegalArgumentException(STRANGE_INPUT_VALUES_ERR);
    }

    public static void validateLottoIntRange(int number){
        if( 0 > number || number > 45 )
            throw new IllegalArgumentException(OUT_OF_RANGE_LOTTO_NUMBER_ERR);
    }
}
