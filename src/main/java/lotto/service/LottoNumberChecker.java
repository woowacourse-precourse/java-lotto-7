package lotto.service;

import lotto.domain.LottoRank;

import java.util.List;

public class LottoNumberChecker {

    public LottoRank checkLottoRank(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = countMatchingNumbers(lottoNumbers, winningNumbers);
        boolean hasBonus = containsBonusNumber(lottoNumbers, bonusNumber);
        return LottoRank.valueOf(matchCount, hasBonus);
    }

    public LottoRank check(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        return checkLottoRank(lottoNumbers, winningNumbers, bonusNumber);
    }

    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean containsBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}