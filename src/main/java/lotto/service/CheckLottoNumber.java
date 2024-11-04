package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckLottoNumber {
    public List<Integer> checkNumber(List<Lotto> lotto, Lotto lottoResult, int bonusNumber) {
        List<Integer> winners = new ArrayList<>();
        for(Lotto lo : lotto) {
            int countNumber = countEqualsNumber(lo, lottoResult, bonusNumber);
            if(countNumber > 2) {
                winners.add(countNumber);
            }
        }
        return winners;
    }
    private int countEqualsNumber(Lotto lotto, Lotto lottoResult, int bonusNumber) {
        Set<Integer> lottoNumbers = new HashSet<>(lotto.getNumbers());
        Set<Integer> lottoResultNumbers = new HashSet<>(lottoResult.getNumbers());

        lottoNumbers.retainAll(lottoResultNumbers);
        if(lottoNumbers.size() == 5 && checkBonusNumber(lotto, bonusNumber)) {
            return 7;
        }
        return lottoNumbers.size();
    }
    private boolean checkBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }
}
