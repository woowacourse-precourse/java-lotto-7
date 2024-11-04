package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.ResultOfLotto;
import lotto.domain.WinningRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.domain.WinningRank.calculateLottoRank;

public class CalculateResult {
    public static List<WinningRank> calculateResult(List<ResultOfLotto> resultOfLottos){
        List<WinningRank> resultList = new ArrayList<>();
        for (ResultOfLotto resultOfLotto: resultOfLottos) {
            int matchingNumber = resultOfLotto.getNumberOfMatching();
            boolean isBonusNumberCorrect = resultOfLotto.isBonusNumberCorrect();
            WinningRank winningRank = calculateLottoRank(matchingNumber, isBonusNumberCorrect);
            System.out.println(winningRank);
            resultList.add(winningRank);
        }
        return resultList;
    }
}
