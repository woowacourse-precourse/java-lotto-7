package lotto;

public interface WinningStrategy {

    public WinningStatus checkPrize(Lotto lotto, WinningLotto winningLotto);

}
