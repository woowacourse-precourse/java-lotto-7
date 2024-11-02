package lotto.domain.util;

import java.util.ArrayList;
import java.util.List;

public final class WinningNumber {

    private final static String DELIMITER = ",";

    public static List<Integer> create(String input) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] inputNumbers = input.split(DELIMITER);
        for (String inputNumber : inputNumbers) {
            int winningNumber = Integer.parseInt(inputNumber.trim());
            winningNumbers.add(winningNumber);
        }
        return winningNumbers;
    }

}
