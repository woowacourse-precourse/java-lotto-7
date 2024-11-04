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
import static lotto.constants.LottoConstants.PURCHASE_AMOUNT_UNIT;

public class LottoService {
    private final List<Lotto> lottoNumbers = new ArrayList<>();

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }
    // 로또 구매
    public void purchaseLotto (int lottoPurchaseCount) {
        for (int i = 0; i < lottoPurchaseCount; i++) {
            lottoNumbers.add(
                    new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT)));
        }
    }

    // 로또 당첨 확인
    public void updateWinningStatus(LottoWinningTierManager lottoWinningTierManager, LottoWinningNumbers winningNumbers) {
        for (Lotto lotto : lottoNumbers) {
            lottoWinningTierManager.increaseLottoWinningTier(
                    checkMatchLottoNumbers(lotto, winningNumbers),
                    checkMatchBonusNumber(lotto, winningNumbers));
        }
    }
    private int checkMatchLottoNumbers(Lotto lotto, LottoWinningNumbers winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers.getWinningNumbers()::contains)
                .count();
    }
    private boolean checkMatchBonusNumber(Lotto lotto, LottoWinningNumbers winningNumbers) {
        return lotto.getNumbers().contains(winningNumbers.getBonusNumber());
    }

    // 수익률 계산
    public double calculateTotalProfitRate (LottoWinningTierManager lottoWinningTierManager) {
        return ((double) lottoWinningTierManager.calculateTotalPrize() /
                (lottoNumbers.size() * PURCHASE_AMOUNT_UNIT)) * RATE_COUNT;
    }
}
