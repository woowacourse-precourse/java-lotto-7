package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputParser {

    public static List<Integer> parseNumbers(String input) {
        StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
        List<Integer> numbers = new ArrayList<>();

        while (stringTokenizer.hasMoreElements()) {
            numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        return numbers;
    }
}
