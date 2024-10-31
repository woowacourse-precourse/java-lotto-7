package lotto.parser;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberParser {

    public static List<Integer> parseRawWinningNumbers(String rawWinningNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] cootents = rawWinningNumber.split(",");

        for(String content : cootents) {
            int number = Integer.parseInt(content);
            winningNumbers.add(number);
        }
        return winningNumbers;
    }
}
