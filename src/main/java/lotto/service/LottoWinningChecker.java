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
            int winningNum = changeStringToNum(winningNumStr);
            winningNumbs.add(winningNum);
        }
    }

    public HashSet<Integer> getWinningNumbs() {
        return winningNumbs;
    }

    public int changeStringToNum(String inputString) {
        int returnNum;
        try {
            returnNum = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[Error] 숫자를 입력해주세요");
        }
        return returnNum;
    }


}
