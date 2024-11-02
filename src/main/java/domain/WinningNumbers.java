package domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    public static List<Integer> generateWinningNumbers(String winningNumber) {
        List<Integer> winningNumberCollection = new ArrayList<>();
        winningNumberCollection.add(Integer.parseInt(winningNumber));
        return winningNumberCollection;
    }
}
