package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(final Lotto winningLotto, final LottoNumber bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Integer matchCount(final Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winningLotto.getNumbers().contains(number))
                .count();
    }

    public Boolean isBonusMatch(final Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }

    private void validateBonusNumber(final Lotto winningLotto, final LottoNumber bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 번호가 존재합니다.");
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber.getNumber();
    }
}
