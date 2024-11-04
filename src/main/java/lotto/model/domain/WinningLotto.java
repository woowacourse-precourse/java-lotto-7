package lotto.model.domain;

public class WinningLotto {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateNoDuplicate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateNoDuplicate(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public LottoRank determineRank(Lotto lotto) {
        int matchCount = (int) winningNumbers.getNumbers().stream()
                .filter(winningNumber -> lotto.getNumbers().contains(winningNumber.getNumber()))
                .count();

        boolean isBonusMatched = lotto.getNumbers().contains(bonusNumber.getBonusNumber().getNumber());

        return LottoRank.of(matchCount, isBonusMatched);
    }
}
