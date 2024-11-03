package lotto.util;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.ErrorMessage.*;

public class Parse {

    public static int parseInteger(String number){
        try{
            return Integer.parseInt(number);
        } catch(NumberFormatException err){
            throw new IllegalArgumentException(INVALID_NUMBER.getErrorMessage());
        }
    }

    public static List<Integer> parseLottoStringToInteger(String number){
        List<String> strings = Separator.separateLottoNumbers(number);
        List<Integer> lotto = new ArrayList<>();
        for (String string : strings) {
            int parseNumber = parseInteger(string);
            lotto.add(parseNumber);
        }
        return lotto;
    }
}
