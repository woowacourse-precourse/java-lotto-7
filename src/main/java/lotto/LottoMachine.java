package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.CustomError;
import lotto.enums.LottoResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoMachine {
    private static final int MINIMUM_MATCH_COUNT_FOR_PRIZE = 3;

    public List<Lotto> purchaseLotto(int purchaseAmount) {
        if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(CustomError.INVALID_PURCHASE_INPUT.getErrorMessage());
        }

        List<Lotto> lotto = new ArrayList<>();

        for (int lottoCnt = 0; lottoCnt < (purchaseAmount / 1000); lottoCnt++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            lotto.add(new Lotto(lottoNumbers));
        }

        return lotto;
    }

    public List<LottoResult> checkLottoResult(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        List<LottoResult> lottoResult = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoResult.add(calculateLottoResult(lotto, winningNumbers, bonusNumber));
        }

        return lottoResult;
    }

    private LottoResult calculateLottoResult(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        HashSet<Integer> winningNumber = new HashSet<>(winningNumbers);
        int lottoNumMatchCnt = 0;
        int bonusNumMatchCnt = 0;
        for (Integer lottoNumber : lottoNumbers) {

            if (winningNumber.contains(lottoNumber)) {
                lottoNumMatchCnt++;
            }

            if (lottoNumber.equals(bonusNumber)) {
                bonusNumMatchCnt++;
            }

        }
        return getLottoResult(lottoNumMatchCnt, bonusNumMatchCnt);
    }

    private LottoResult getLottoResult(int matchCnt, int bonusMathCnt) {
        if (!hasPrizeMoney(matchCnt)) {
            return LottoResult.NO_PRIZE;
        }

        List<LottoResult> hasPrizeMoneyLottoResults = LottoResult.hasPrizeMoneyResult();
        for (LottoResult lottoResult : hasPrizeMoneyLottoResults) {

            if (lottoResult.getMatchCnt() == matchCnt && lottoResult.getBonusMatchCnt() == bonusMathCnt) {
                return lottoResult;
            }

        }

        throw new IllegalArgumentException(CustomError.INVALID_LOTTO_MATCH_COUNT.getErrorMessage());
    }

    private boolean hasPrizeMoney(int matchCnt) {
        return matchCnt >= MINIMUM_MATCH_COUNT_FOR_PRIZE;
    }

}
