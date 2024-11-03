package lotto.domain;

public class WinNumber {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    private WinNumber(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinNumber of(Lotto lotto, BonusNumber bonusNumber) {
        return new WinNumber(lotto, bonusNumber);
    }
}
