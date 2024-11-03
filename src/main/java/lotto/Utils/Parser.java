package lotto.Utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static int stringToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> stringToNumberList(String input) {
        String[] tokens = input.split(",");
        List<Integer> result = new ArrayList<>();

        for (String token : tokens) {
            result.add(stringToInteger(token));
        }

        return result;
    }

}
