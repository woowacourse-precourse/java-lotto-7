package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.Utils;
import lotto.validation.LottoValidator;

public class Parser {
    public static List<Integer> parseWinningNumbs(String inputWinningNumbs) {
        String[] winningNumbsStrs = inputWinningNumbs.split(",");
        for (String winningNumbsStr : winningNumbsStrs) {
            LottoValidator.validateEmptyString(winningNumbsStr);
        }
        LottoValidator.validateWinningNumbsSize(winningNumbsStrs);

        return  createWinningnumbs(winningNumbsStrs);
    }

    private static List<Integer> createWinningnumbs(String[] winningNumbsStrs) {
        List<Integer> winningNumbs = new ArrayList<>();
        for (String winningNumStr : winningNumbsStrs) {
            int winningNum = Utils.changeStringToNum(winningNumStr);
            LottoValidator.isLottoNumInRange(winningNum);
            winningNumbs.add(winningNum);
        }
        return winningNumbs;
    }
}
