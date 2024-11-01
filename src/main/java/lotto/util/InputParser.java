package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputParser {

    public static List<Integer> parseNumbers(String input) {
        StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
        List<Integer> numbers = new ArrayList<>();

        try {
            while (stringTokenizer.hasMoreElements()) {
                numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }

        return numbers;
    }
}
