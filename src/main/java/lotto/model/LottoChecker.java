package lotto.model;

import java.util.*;

public class LottoChecker {

    public void lottoCheckingProcess(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber, LottoResult lottoResult) {
        analyzeLottoResult(lotto, winningNumbers, bonusNumber);

    }

    public Map<String, Object> analyzeLottoResult(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        Integer matchCount = checkMatchCount(lotto, winningNumbers);
        Boolean isBonusMatched = checkBonusMatch(lotto,bonusNumber);
    }

    public boolean checkBonusMatch(Lotto lotto, Integer bonusNumber) {

    }

    public Integer checkMatchCount(Lotto lottoInput , List<Integer> winningNumbersInput) {

    }

}
