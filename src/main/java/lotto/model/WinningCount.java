package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningCount {
    List<Integer> winningCount;

    public WinningCount() {
        winningCount = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));
    }

    public List<Integer> getWinningCount() {
        return winningCount;
    }

    public void increaseWinningCount(int index) {
        winningCount.set(index, winningCount.get(index) + 1);
    }
}
