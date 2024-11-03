package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoCollection;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;

import java.util.List;

import static lotto.util.constant.LottoConstants.ZERO;

public class LottoPrizeService {

    public static void calculateProfit(long purchaseAmount, LottoResult lottoResult) {
        float totalProfit = (float) LottoResult.getTotalPrize() / purchaseAmount * 100;
        totalProfit = Math.round(totalProfit * 10) / 10.0f;  // 소수점 첫째 자리로 반올림

        LottoResult.setProfit(totalProfit);
    }


    public static void checkPrizeOfLotto(LottoCollection lottoCollection, LottoResult lottoResult) {
        List<Lotto> totalLotto = lottoCollection.getLotto();
        Lotto winnerLotto = lottoCollection.getWinnerLotto();
        int bonusNumber = lottoCollection.getBonusNumber();

        for (Lotto lotto : totalLotto) {
            LottoPrize prize = checkEachLottoPrize(winnerLotto, bonusNumber, lotto);
            lottoResult.incrementPrizeCount(prize);
        }
    }

    static LottoPrize checkEachLottoPrize(Lotto winnerLotto, int bonusNumber, Lotto targetLotto) {
        int matchCount = calculateMatchCount(winnerLotto, targetLotto);
        boolean hasBonusNumber = checkBonusNumber(bonusNumber, targetLotto);

        return determinePrize(matchCount, hasBonusNumber);
    }

    static int calculateMatchCount(Lotto winnerLotto, Lotto targetLotto) {
        int count = ZERO;
        List<Integer> winnerLottoNumbers = winnerLotto.getNumbers();
        List<Integer> targetLottoNumbers = targetLotto.getNumbers();

        for (int number : targetLottoNumbers) {
            if (winnerLottoNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkBonusNumber(int bonusNumber, Lotto targetLotto) {
        return targetLotto.getNumbers().contains(bonusNumber);
    }

    private static LottoPrize determinePrize(int matchCount, boolean hasBonusNumber) {
        if (matchCount == 6) {
            return LottoPrize.FIRST;
        }
        if (matchCount == 5 && hasBonusNumber) {
            return LottoPrize.SECOND;
        }
        if (matchCount == 5) {
            return LottoPrize.THIRD;
        }
        if (matchCount == 4) {
            return LottoPrize.FOURTH;
        }
        if (matchCount == 3) {
            return LottoPrize.FIFTH;
        }
        return LottoPrize.NO_PRIZE;
    }

}
