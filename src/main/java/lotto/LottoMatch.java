package lotto;

public class LottoMatch {
    public static Long calculateMatchCount(Lotto lotto, WinningLotto winningLotto) {
        return lotto.matchCount(winningLotto);
    }

    public static boolean isMatchBonus(Lotto lotto, WinningLotto winningLotto) {
        return lotto.matchBonus(winningLotto);
    }
}
