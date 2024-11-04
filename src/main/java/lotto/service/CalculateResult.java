package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.domain.WinningRank.calculateLottoRank;

public class CalculateResult {
    public static List<Enum> calculateResult(Map<Integer, Boolean> matchingResult){
        List<Enum> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Boolean> entry : matchingResult.entrySet()) {
            int matchingNumber = entry.getKey();
            boolean isBonusNumberCorrect = entry.getValue();

            Enum winningRank = calculateLottoRank(matchingNumber, isBonusNumberCorrect);
            resultList.add(winningRank);
        }
        return resultList;
    }
}
