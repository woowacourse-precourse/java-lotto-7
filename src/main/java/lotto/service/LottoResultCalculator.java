package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoBonusNumber;
import lotto.model.LottoBundle;
import lotto.model.LottoPrizeType;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class LottoResultCalculator {
    public void calculatePrizeResult(LottoBundle lottoBundle, LottoBonusNumber lottoBonusNumber, Lotto winningLotto) {
        Map<LottoPrizeType, Integer> lottoPrizes = lottoBundle.matchCountWithBonus(winningLotto, lottoBonusNumber);
    }
}
