package lotto.domain.util;

import java.util.ArrayList;
import java.util.List;

public class CreateWinningNumber {

    private final static String DELIMITER = ",";

    private CreateWinningNumber() {
    }

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
