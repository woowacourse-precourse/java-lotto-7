package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.ResultOfLotto;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckLotto {
    public static List<ResultOfLotto> checkLottoRank(WinningLotto winningLotto, List<Lotto> purchasedLottoNumbers, int bonusNumber){
        List<ResultOfLotto> resultOfLottos = new ArrayList<>();

        List<Integer> winningLottoNumber = new ArrayList<>();
        int winningBonusNumber = 0;
        int numberOfMatching = 0;
        boolean isBonusNumberCorrect = false;
        for (Map.Entry<Lotto, Integer> entry : winningLotto.getWinningLotto().entrySet()) {
            winningLottoNumber = entry.getKey().getLottoNumbers();
            winningBonusNumber = entry.getValue();
        }
        for(Lotto purchasedLotto : purchasedLottoNumbers){
            List<Integer> purchasedLottoNumber = purchasedLotto.getLottoNumbers();
            numberOfMatching = checkLottoNumbers(winningLottoNumber, purchasedLottoNumber);
            isBonusNumberCorrect = checkBonusNumber(winningBonusNumber, bonusNumber);
            ResultOfLotto resultOfLotto = new ResultOfLotto(numberOfMatching, isBonusNumberCorrect);
            resultOfLottos.add(resultOfLotto);
        }

        return resultOfLottos;
    }

    public static boolean checkBonusNumber(int winningBonusNumber, int bonusNumber){
        return winningBonusNumber == bonusNumber;
    }

    public static int checkLottoNumbers(List<Integer> winningLottoNumber, List<Integer> purchasedLottoNumber){
        long numberOfMatchNumber = purchasedLottoNumber.stream()
                .filter(winningLottoNumber::contains)
                .count();

        return (int)numberOfMatchNumber;
    }
}
