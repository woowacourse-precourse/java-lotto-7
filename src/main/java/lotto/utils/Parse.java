package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class Parse {
    public static List<Integer> winningNumbers(String buffer) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] numbers = buffer.split(",");
        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }
}
