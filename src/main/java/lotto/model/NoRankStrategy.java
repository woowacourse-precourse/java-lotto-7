package lotto.model;

public class NoRankStrategy implements LottoWinningStrategy {

    @Override
    public boolean isWinning(WinningLotto winningLotto, Lotto myLotto, BonusNumber bonusNumber) {
        return false;
    }
}
