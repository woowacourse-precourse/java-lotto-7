package lotto;

public class LottoMatch {

    public static Long calculateWinnings(Lotto lotto, WinningLotto winningLotto) {
        return lotto.matchNumbers(winningLotto);
    }

    public static boolean hasBonusMatch(Lotto lotto, WinningLotto winningLotto) {
        return lotto.matchBonus(winningLotto);
    }
}
