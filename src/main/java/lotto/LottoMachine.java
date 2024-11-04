package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.CustomError;
import lotto.enums.LottoResultType;

import java.util.ArrayList;
import java.util.Comparator;
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
            lottoNumbers.sort(Comparator.naturalOrder());

            lotto.add(new Lotto(lottoNumbers));
        }

        return lotto;
    }

    public List<LottoResultType> checkLottoResult(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        List<LottoResultType> lottoResultType = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoResultType.add(calculateLottoResult(lotto, winningNumbers, bonusNumber));
        }

        return lottoResultType;
    }

    private LottoResultType calculateLottoResult(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
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

    private LottoResultType getLottoResult(int matchCnt, int bonusMathCnt) {
        if (matchCnt < MINIMUM_MATCH_COUNT_FOR_PRIZE) {
            return LottoResultType.NO_PRIZE;
        }
        if (matchCnt == LottoResultType.SECOND_PLACE.getMatchCnt()
                && bonusMathCnt == LottoResultType.SECOND_PLACE.getBonusMatchCnt()) {
            return LottoResultType.SECOND_PLACE;
        }
        List<LottoResultType> hasPrizeMoneyLottoResultTypes = LottoResultType.hasPrizeMoneyLottoResultType();
        for (LottoResultType lottoResultType : hasPrizeMoneyLottoResultTypes) {
            if (lottoResultType.getMatchCnt() == matchCnt) {
                return lottoResultType;
            }
        }

        throw new IllegalArgumentException(CustomError.INVALID_LOTTO_MATCH_COUNT.getErrorMessage());
    }

}
