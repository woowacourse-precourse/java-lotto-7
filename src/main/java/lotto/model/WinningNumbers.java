package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

}
