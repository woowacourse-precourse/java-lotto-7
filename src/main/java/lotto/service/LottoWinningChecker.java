package lotto.service;

import java.util.HashSet;
import lotto.utils.Utils;
import lotto.validation.LottoValidator;

public class LottoWinningChecker {
    private HashSet<Integer> winningNumbs;

    LottoWinningChecker() {
        winningNumbs = new HashSet<>();
    }

    public void setWinningNumbs(String inputWinningNumbs) {
        String[] winningNumbsStrs = inputWinningNumbs.split(",");
        for (String winningNumbsStr : winningNumbsStrs) {
            LottoValidator.validateEmptyString(winningNumbsStr);
        }
        LottoValidator.validateWinningNumbsSize(winningNumbsStrs);
        for (String winningNumStr : winningNumbsStrs) {
            int winningNum = changeStringToNum(winningNumStr);
            LottoValidator.isLottoNumInRange(winningNum);
            winningNumbs.add(winningNum);
        }
    }

    public HashSet<Integer> getWinningNumbs() {
        return winningNumbs;
    }

    public int changeStringToNum(String inputString) {
        int returnNum;
        try {
            returnNum = Integer.parseInt(inputString.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Utils.makeErrorMessage("숫자를 입력해주세요"));
        }
        return returnNum;
    }


}
