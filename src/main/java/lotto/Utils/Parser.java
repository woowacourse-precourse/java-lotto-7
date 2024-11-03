package lotto.Utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static int stringToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> stringToNumberList(String[] input) {
        List<Integer> result = new ArrayList<Integer>();

        for (String s : input) {
            result.add(stringToInteger(s));
        }

        return result;
    }

}
