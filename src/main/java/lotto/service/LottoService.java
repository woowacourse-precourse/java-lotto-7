package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.LottoWinningTier;
import lotto.domain.LottoWinningTierManager;

public class LottoService {
    public List<Lotto> purchaseLotto (int lottoPurchaseCount) {
        List<Lotto> purchaseLottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoPurchaseCount; i++) {
            purchaseLottoNumbers.add(
                    new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return purchaseLottoNumbers;
    }

    public void checkWinningStatus(LottoWinningTierManager lottoWinningTierManager, List<Lotto> purchaseLottoNumbers, LottoWinningNumbers winningNumbers) {
        for (Lotto lotto : purchaseLottoNumbers) {
            lottoWinningTierManager.increaseLottoWinningTier(
                    checkMatchLottoNumbers(lotto, winningNumbers),
                    checkMatchBonusNumber(lotto, winningNumbers));
        }
    }
    public int checkMatchLottoNumbers(Lotto lotto, LottoWinningNumbers winningNumbers) {
        int matchCount = 0;
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

    public double calculateTotalProfitRate (LottoWinningTierManager lottoWinningTierManager, int purchaseAmount) {
        return ((double) lottoWinningTierManager.calculateTotalPrize() / purchaseAmount) * 100;
    }
}
