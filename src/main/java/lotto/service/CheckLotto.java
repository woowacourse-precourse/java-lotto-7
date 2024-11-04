package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import java.util.List;
import java.util.Map;

public class CheckLotto {
    private Map<Integer, Boolean> checkLottoRank(WinningLotto lotto, List<Lotto> purchasedLottoNumbers, int bonusNumber){
        Map<Integer, Boolean> matchingResult = null;

        List<Integer> winningLottoNumber = null;
        int winningBonusNumber = 0;
        int numberOfMatching = 0;
        boolean isBonusNumberCorrect = false;
        for (Map.Entry<Lotto, Integer> entry : lotto.getWinningLotto().entrySet()) {
            winningLottoNumber = entry.getKey().getLottoNumbers();
            winningBonusNumber = entry.getValue();
        }

        for(Lotto purchasedLotto : purchasedLottoNumbers){
            List<Integer> purchasedLottoNumber = purchasedLotto.getLottoNumbers();

            numberOfMatching = checkLottoNumbers(winningLottoNumber, purchasedLottoNumber);
            isBonusNumberCorrect = checkBonusNumber(winningBonusNumber, bonusNumber);

            matchingResult.put(numberOfMatching, isBonusNumberCorrect);
        }

        return matchingResult;
    }

    public static boolean checkBonusNumber(int winningBonusNumber, int bonusNumber){
        return winningBonusNumber == bonusNumber;
    }

    private int checkLottoNumbers(List<Integer> winningNumber, List<Integer> purchasedLottoNumber){
        long numberOfMatchNumber = purchasedLottoNumber.stream()
                .filter(winningNumber::contains)
                .count();

        return (int)numberOfMatchNumber;
    }
}
