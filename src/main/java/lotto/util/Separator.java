package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    public static List<Integer> parseInputToList(String input) {
        String[] numbers = input.split(",");
        List<Integer> result = new ArrayList<>();
        for (String num : numbers) {
            result.add(Integer.parseInt(num.trim()));
        }
        return result;
    }
}
