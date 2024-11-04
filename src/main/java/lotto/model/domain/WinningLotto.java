package lotto.model.domain;

import static lotto.constant.ErrorMessages.DUPLICATE_BONUS_NUMBER_ERROR;

public class WinningLotto {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public static WinningLotto of(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateNoDuplicate(winningNumbers, bonusNumber);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public WinningLotto(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank determineRank(Lotto lotto) {
        int matchCount = (int) winningNumbers.getNumbers().stream()
                .filter(winningNumber -> lotto.getNumbers().contains(winningNumber.getNumber()))
                .count();

        boolean isBonusMatched = lotto.getNumbers().contains(bonusNumber.getBonusNumber().getNumber());

        return LottoRank.of(matchCount, isBonusMatched);
    }

    private static void validateNoDuplicate(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERROR);
        }
    }
}
