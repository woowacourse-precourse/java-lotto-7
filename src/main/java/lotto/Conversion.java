package lotto;

import java.util.ArrayList;
import java.util.List;

public class Conversion {
    public static List<Integer> parseInput(String input) {
        String[] splitInput = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : splitInput) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }
}
