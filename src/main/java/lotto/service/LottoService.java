package lotto.service;

import lotto.domain.Lotto;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.LottoWinningTierManager;

import static lotto.constants.LottoConstants.MIN_NUMBER;
import static lotto.constants.LottoConstants.MAX_NUMBER;
import static lotto.constants.LottoConstants.NUMBER_COUNT;
import static lotto.constants.LottoConstants.RATE_COUNT;
import static lotto.constants.LottoConstants.ZERO;

public class LottoService {
    // 로또 구매
    public List<Lotto> purchaseLotto (int lottoPurchaseCount) {
        List<Lotto> purchaseLottoNumbers = new ArrayList<>();
        for (int i = ZERO; i < lottoPurchaseCount; i++) {
            purchaseLottoNumbers.add(
                    new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT)));
        }
        return purchaseLottoNumbers;
    }

    // 로또 당첨 확인
    public void updateWinningStatus(LottoWinningTierManager lottoWinningTierManager, List<Lotto> purchaseLottoNumbers, LottoWinningNumbers winningNumbers) {
        for (Lotto lotto : purchaseLottoNumbers) {
            lottoWinningTierManager.increaseLottoWinningTier(
                    checkMatchLottoNumbers(lotto, winningNumbers),
                    checkMatchBonusNumber(lotto, winningNumbers));
        }
    }
    public int checkMatchLottoNumbers(Lotto lotto, LottoWinningNumbers winningNumbers) {
        int matchCount = ZERO;
        for (int lottoNumber : lotto.getNumbers()) {
            if (winningNumbers.getWinningNumbers().contains(lottoNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }
    public boolean checkMatchBonusNumber(Lotto lotto, LottoWinningNumbers winningNumbers) {
        return lotto.getNumbers().contains(winningNumbers.getBonusNumber());
    }

    // 수익률 계산
    public double calculateTotalProfitRate (LottoWinningTierManager lottoWinningTierManager, int purchaseAmount) {
        return ((double) lottoWinningTierManager.calculateTotalPrize() / purchaseAmount) * RATE_COUNT;
    }
}
