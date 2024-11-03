package lotto.domain;

import static lotto.domain.LottoConstants.IS_DUPLICATE_NUMBER;
import static lotto.domain.LottoConstants.IS_NOT_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.NOT_VALIDATE_NUMBER;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, String bonusNumber) {
        this(winningLotto, convertToInt(bonusNumber));
    }

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validateBonusNumber(bonusNumber, winningLotto);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private static int convertToInt(String input) {
        try {
            int number = Integer.parseInt(input.trim());
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_VALIDATE_NUMBER);
        }
    }

    private void validateBonusNumber(int bonusNumber, Lotto winningLotto) {
        if (bonusNumber < LottoConstants.LOTTO_MIN_NUM || bonusNumber > LottoConstants.LOTTO_MAX_NUM) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_NUMBER);
        }
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(IS_DUPLICATE_NUMBER);
        }
    }

    public List<Integer> getWinningLotto() {
        return winningLotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public LottoRank getLottoResult(Lotto lotto) {
        int equalCount = getMatchCount(lotto);
        return LottoRank.matchRank(equalCount, lotto.isNumberContain(bonusNumber));
    }

    private int getMatchCount(Lotto lotto) {
        return (int) getWinningLotto().stream()
                .filter(num -> lotto.isNumberContain(num))
                .count();
    }
}
