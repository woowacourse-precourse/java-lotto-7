package lotto.service;

import java.util.HashSet;

public class LottoWinningChecker {

    private HashSet<Integer> winningNumbs;

    LottoWinningChecker() {
        winningNumbs = new HashSet<>();
    }

    public void setWinningNumbs(String inputWinningNumbs) {
        String[] winningNumbsStrs = inputWinningNumbs.split(",");
        for (String winningNumStr : winningNumbsStrs) {
            int winningNum = Integer.parseInt(winningNumStr);
            winningNumbs.add(winningNum);
        }
    }

    public HashSet<Integer> getWinningNumbs() {
        return winningNumbs;
    }

}
