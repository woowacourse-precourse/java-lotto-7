package lotto.domain;

import static lotto.util.Constants.ERROR_PREFIX;
import static lotto.util.Constants.LOTTO_MAX_NUMBER;
import static lotto.util.Constants.LOTTO_MIN_NUMBER;

public class WinningCalculator {
    private static final String DUPLICATE_BONUS_NUMBER = ERROR_PREFIX + "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final String RANGE_ERROR_MESSAGE = ERROR_PREFIX + "보너스 번호는 1부터 45 사이여야 합니다.";

    private PurchaseLottos purchaseLottos;
    private Lotto winningLotto;
    private int bonusNumber;

    public void saveLottos(PurchaseLottos purchaseLottos) {
        this.purchaseLottos = purchaseLottos;
    }

    public void saveWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void saveBonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public WinningResult calculate() {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : purchaseLottos.getLottos()) {
            Rank rank = Rank.calculate(lotto.matchCount(winningLotto), lotto.hasNumber(bonusNumber));
            winningResult.add(rank);
        }
        return winningResult;
    }

    private void validate(int bonusNumber) {
        if (winningLotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER);
        }
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }
}
