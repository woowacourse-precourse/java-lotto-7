package lotto.lotto.service;

import java.util.List;
import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.LottoWinning;
import lotto.lotto.domain.value.LottoRank;
import lotto.lotto.domain.value.LottoRankFinder;

public class LottoRankCalculator {

    private static final int BONUS_MATCHED_NUMBERS = 5;

    public LottoRank calculateRank(Lotto lotto, LottoWinning lottoWinning) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = lottoWinning.getLotto().getNumbers();
        int bonusNumber = lottoWinning.getBonusNumber();

        int matched = countMatchedNumbers(lottoNumbers, winningNumbers);
        if (matched == BONUS_MATCHED_NUMBERS) {
            return determineRankWithBonus(lottoNumbers, bonusNumber);
        }
        return LottoRankFinder.findLottoRankByMatchCount(matched, false);
    }

    private int countMatchedNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matched = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matched++;
            }
        }
        return matched;
    }

    private LottoRank determineRankWithBonus(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            return LottoRank.MATCHED5_BONUS;
        }
        return LottoRank.MATCHED5;
    }


}
