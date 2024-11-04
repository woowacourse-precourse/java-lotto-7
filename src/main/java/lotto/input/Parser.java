package lotto.input;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Integer> toInts(String[] inputs) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            numbers.add(toInt(input));
        }
        return numbers;
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }


}
