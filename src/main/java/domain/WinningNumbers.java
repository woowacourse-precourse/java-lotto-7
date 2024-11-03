package domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    public static List<Integer> generateWinningNumbers(String winningNumber) {
        List<Integer> winningNumberCollection = new ArrayList<>();
        String[] numbers = winningNumber.split(",");

        for (String number : numbers) {
            winningNumberCollection.add(Integer.parseInt(number.trim()));
        }
        return winningNumberCollection;
    }
}
