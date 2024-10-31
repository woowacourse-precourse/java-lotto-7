package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningCountDTO {
    public List<Integer> getWinningCount() {
        return winningCount;
    }

    List<Integer> winningCount;

    public WinningCountDTO() {
        winningCount = new ArrayList<>(List.of(0, 0, 0, 0, 0));
    }

    public void increaseWinningCount(int index) {
        winningCount.set(index, winningCount.get(index) + 1);
    }
}
