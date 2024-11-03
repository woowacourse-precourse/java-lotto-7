package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoConstant;
import lotto.constant.NumberConstant;
import lotto.model.Lotto;
import lotto.model.LottoGrade;
import lotto.model.LottoResult;

public class LottoService {

    public List<Integer> makeLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_RANGE_START, LottoConstant.LOTTO_RANGE_END,
                LottoConstant.LOTTO_SIZE);
    }

    public LottoGrade checkLottoGrade(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int correctCount = getCorrectNumberCount(lotto, winningLotto);
        boolean hasBonusNumber = lotto.hasNumber(bonusNumber);
        return LottoGrade.getGrade(correctCount, hasBonusNumber);
    }

    public int getCorrectNumberCount(Lotto lotto, Lotto winningLotto) {
        List<Integer> winningLottoNumbers = new ArrayList<>(winningLotto.getNumbers());
        List<Integer> lottoNumbers = new ArrayList<>(lotto.getNumbers());
        int totalSize = winningLottoNumbers.size() + lottoNumbers.size();
        winningLottoNumbers.addAll(lottoNumbers);
        Set<Integer> mergeLottoNumbers = new HashSet<>(winningLottoNumbers);
        return totalSize - mergeLottoNumbers.size();
    }

    public double calculateRateOfReturn(int lottoValue, int lottoCost) {
        if (lottoCost == NumberConstant.ZERO) {
            return NumberConstant.ZERO;
        }
        double rateOfReturn = ((double) lottoValue / lottoCost) * NumberConstant.HUNDRED;
        return Math.round(rateOfReturn * NumberConstant.HUNDRED_ONE_DECIMAL) / NumberConstant.HUNDRED_ONE_DECIMAL;
    }

    public int sumLottoPrize(LottoResult lottoResult) {
        int lottoValue = NumberConstant.ZERO;
        for (LottoGrade lottoGrade : LottoGrade.values()) {
            if (lottoGrade.getRanking() > LottoConstant.LOTTO_MIN_PRIZE_RANKING) {
                continue;
            }
            lottoValue += (lottoGrade.getPrize() * lottoResult.getGradeCount(lottoGrade));
        }
        return lottoValue;
    }

}
