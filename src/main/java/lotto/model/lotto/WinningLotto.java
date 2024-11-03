package lotto.model.lotto;

import view.exception.LottoException;

public final class WinningLotto {
    private static final String WINNING_NUM_DUPLICATE_ERROR = "당첨 번호와 보너스 번호는 중복되지 않아야 합니다.";

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    private WinningLotto(Lotto winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto createWinningLotto(Lotto winninglotto, BonusNumber bonusNumber) {
        validateDuplicate(winninglotto, bonusNumber);
        return new WinningLotto(winninglotto, bonusNumber);
    }

    private static void validateDuplicate(Lotto winninglotto, BonusNumber bonusNumber) {
        if (winninglotto.numberContains(bonusNumber.bonusNumber())) {
            throw new LottoException(WINNING_NUM_DUPLICATE_ERROR);
        }
    }

    public int countMatchNumbers(Lotto lotto) {
        return (int) winningNumbers.getNumbers().stream()
                .filter(lotto::numberContains)
                .count();
    }

    public boolean isMatchBonusNumber(Lotto lotto) {
        return lotto.numberContains(bonusNumber.bonusNumber());
    }
}
