package lotto.service;

import java.util.HashSet;
import java.util.List;

public class LottoWinningChecker {
    private HashSet<Integer> winningNumbs;

    LottoWinningChecker() {
    }

    public void saveWinningNumbs(List<Integer> validatedWinningNumbs) {
        winningNumbs = new HashSet<>(validatedWinningNumbs);
    }

    public HashSet<Integer> getWinningNumbs() {
        return winningNumbs;
    }

}
