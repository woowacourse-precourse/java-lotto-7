package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Winning;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class WinningCalculateService {
    public List<LottoResult> calculateLottoResults(List<Lotto> lottos, WinningLotto winningLotto) {
        List<LottoResult> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            results.add(calculateSingleLottoResult(lotto, winningLotto));
        }

        return results;
    }

    private LottoResult calculateSingleLottoResult(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = 0;
        boolean hasBonusMatch = false;

        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();

        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchCount++;
            }
            if (lottoNumber == bonusNumber) {
                hasBonusMatch = true;
            }
        }
        return determineWinningResult(matchCount, hasBonusMatch);
    }

    private LottoResult determineWinningResult(int matchCount, boolean hasBonusMatch) {
        if (matchCount == 6) {
            return new LottoResult(Winning.FIRST);
        }
        if (matchCount == 5 && hasBonusMatch) {
            return new LottoResult(Winning.SECOND);
        }
        if (matchCount == 5) {
            return new LottoResult(Winning.THIRD);
        }
        if (matchCount == 4) {
            return new LottoResult(Winning.FOURTH);
        }
        if (matchCount == 3) {
            return new LottoResult(Winning.FIFTH);
        }
        return new LottoResult(Winning.NONE);
    }
}