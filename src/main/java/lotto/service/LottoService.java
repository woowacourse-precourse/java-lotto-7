package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.LottoGrade;
import lotto.model.LottoResult;

public class LottoService {

    public List<Integer> makeLottoNumber() {
        int LOTTO_NUMBER_COUNT = 6;
        int LOTTO_NUMBER_START = 1;
        int LOTTO_NUMBER_END = 45;

        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_NUMBER_COUNT);
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
        if (lottoCost == 0) {
            return 0;
        }
        double rateOfReturn = ((double) lottoValue / lottoCost) * 100;
        return Math.round(rateOfReturn * 100.0) / 100.0;
    }

    public int sumLottoPrize(LottoResult lottoResult) {
        int lottoValue = 0;
        for (LottoGrade lottoGrade : LottoGrade.values()) {
            if (lottoGrade.getRanking() >= 6) {
                continue;
            }
            lottoValue += (lottoGrade.getPrize() * lottoResult.getGradeCount(lottoGrade));
        }
        return lottoValue;
    }

}
