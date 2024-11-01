package lotto.model.parseLotto;

import java.util.Arrays;
import java.util.List;


public class ParseLotto {

    private static String winNumberDelimiter = ",";

    public static List<String> splitWinNumber(String winNumbers){
        return Arrays.asList(winNumbers.split(winNumberDelimiter));

    }

    public static List<Integer> winNumberStrToInteger(List<String> winNumbers){
        return winNumbers.stream().map(Integer::parseInt).toList();
    }
}
