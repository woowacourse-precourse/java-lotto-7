package lotto.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private final static String NUMBER_DELIMITER = ",";

    public static Integer parseMoney(String money){
        return Integer.parseInt(money);
    }

    public static List<Integer> parseNumbers(String numbers){
        return Arrays.stream(numbers.split(NUMBER_DELIMITER)).map(Integer::parseInt).toList();
    }

    public static Integer parseBonusNumber(String number){
        return Integer.parseInt(number);
    }
}
