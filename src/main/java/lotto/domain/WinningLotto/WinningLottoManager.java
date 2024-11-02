package lotto.domain.WinningLotto;

public class WinningLottoManager {

    public void recordWinningLotto(int matchedCount, boolean hasBonus) {
        WinningLottoInfo rank = WinningLottoInfo.from(matchedCount, hasBonus);
        rank.incrementCount();
    }
}
