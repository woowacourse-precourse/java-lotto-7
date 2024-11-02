package lotto.service;

import java.util.HashSet;

public class LottoWinningChecker {
    private static final int WINNING_NUM_SIZE = 6;
    private HashSet<Integer> winningNumbs;

    LottoWinningChecker() {
        winningNumbs = new HashSet<>();
    }

    public void setWinningNumbs(String inputWinningNumbs) {
        String[] winningNumbsStrs = inputWinningNumbs.split(",");
        validateEmptyString(winningNumbsStrs);
        validateWinningNumbsSize(winningNumbsStrs);
        for (String winningNumStr : winningNumbsStrs) {
            int winningNum = changeStringToNum(winningNumStr);
            winningNumbs.add(winningNum);
        }
    }

    private void validateWinningNumbsSize(String[] winningNumbsStrs) {
        if (winningNumbsStrs.length!= WINNING_NUM_SIZE) {
            throw new IllegalArgumentException("[Error] 당첨 번호는 6개 이어야 합니다.");
        }
    }

    private void validateEmptyString(String[] winningNumbsStrs) {
        for (String winningNumStr : winningNumbsStrs) {
            if (winningNumStr.trim().isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 빈 문자열을 입력하였습니다.");
            }
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
