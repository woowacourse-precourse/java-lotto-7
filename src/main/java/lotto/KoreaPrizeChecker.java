package lotto;

public class KoreaPrizeChecker implements WinningStrategy {

    @Override
    public WinningStatus checkPrize(Lotto lotto, WinningLotto winningLotto) {
        return WinningStatus.second;
    }
}
