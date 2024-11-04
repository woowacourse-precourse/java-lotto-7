package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class StringParser {

    public static List<Integer> parseStringToWinningNumbers(String numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers.split(",")) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        return winningNumbers;
    }
}
