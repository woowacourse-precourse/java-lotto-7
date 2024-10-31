package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumberCheckService {
    public long checkWinningNumber(List<Integer> randomLotto, List<Integer> winningNumber) {
        Set<Integer> winningNumberSet = new HashSet<>(winningNumber);
        return randomLotto.stream().filter(winningNumberSet::contains).count();
    }
}
