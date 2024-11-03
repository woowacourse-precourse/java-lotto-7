package lotto.model;

import java.util.*;

public class LottoChecker {

    public void lottoCheckingProcess(List<Lotto> allLottos, List<Integer> winningNumbers, Integer bonusNumber, LottoResult lottoResult) {
        analyzeLottoResult(allLottos, winningNumbers, bonusNumber);

    }

    public Map<String, Object> analyzeLottoResult(List<Lotto> allLottos, List<Integer> winningNumbers, Integer bonusNumber) {
        for (Lotto lotto : allLottos) {
            Integer matchCount = checkMatchCount(lotto, winningNumbers);
            Boolean isBonusMatched = checkBonusMatch(lotto,bonusNumber);
        }
    }

    public boolean checkBonusMatch(Lotto lotto, Integer bonusNumber) {

    }

    public Integer checkMatchCount(Lotto lottoInput , List<Integer> winningNumbersInput) {

    }

}
