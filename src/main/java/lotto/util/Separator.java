package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    public static List<Integer> parseInputToList(String input) {
        List<Integer> result = new ArrayList<>();
        if (input == null || input.trim().isEmpty()) {
            return result;
        }
        String[] numbers = input.split(",");
        for (String num : numbers) {
            result.add(Integer.parseInt(num.trim()));
        }
        return result;
    }
}
