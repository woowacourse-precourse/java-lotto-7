package validate;

import lotto.Lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoValidate {
    private static final String OUT_OF_RANGE_LOTTO_NUMBER_ERR = "out of range lotto number";
    private static final String ALPHABET_REGEX = "[a-zA-Z]";

    public static boolean validateOnlyNumberWithSpecialChar(String input, String numberRegex, String specialCharRegex){
        String regex = numberRegex+"|"+numberRegex+"|[ ]+";
        return input.matches(regex);
    }

    public static void validateLottoIntRange(int number){
        if( 0 > number || number < 45 )
            throw new IllegalArgumentException(OUT_OF_RANGE_LOTTO_NUMBER_ERR);
    }
}
