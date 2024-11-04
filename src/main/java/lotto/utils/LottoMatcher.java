package lotto.utils;

import lotto.BonusNumber;
import lotto.Lotto;
import lotto.WinningNumber;

import java.util.List;

import static lotto.constant.PrizeMoney.*;

public class LottoMatcher {

    public static Long match(Lotto lotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningNumber.getWinningNumbers();
        Integer bonus = bonusNumber.getBonusNumber();

        boolean hasBonus = lottoNumbers.contains(bonus);

        long matchCount = getMatchCount(lottoNumbers, winningNumbers);

        return calculatePrizeAmount(matchCount, hasBonus);
    }

    private static long getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private static long calculatePrizeAmount(long matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            return FIFTH_PRIZE.getPrize();
        }
        if (matchCount == 5 && hasBonus) {
            return SECOND_PRIZE.getPrize();
        }
        if (matchCount == 5) {
            return THIRD_PRIZE.getPrize();
        }
        if (matchCount == 4) {
            return FORTH_PRIZE.getPrize();
        }
        if (matchCount == 3) {
            return FIFTH_PRIZE.getPrize();
        }

        return 0L;
    }
}
