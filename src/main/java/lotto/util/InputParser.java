package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    public int parsePurchasePrice(String purchasePrice) {
        return Integer.parseInt(purchasePrice);
    }

    public List<Integer> parseWinningNumbers(String winningNumbers) {
        String[] splittedWinningNumbers = winningNumbers.split(",");
        List<Integer> winningNumberList = new ArrayList<>();
        for (String splittedWinningNumber : splittedWinningNumbers) {
            winningNumberList.add(Integer.parseInt(splittedWinningNumber));
        }
        return winningNumberList;
    }
}
