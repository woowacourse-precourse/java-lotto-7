package lotto.model;

import lotto.common.constant.WinningInfo;

import java.util.HashMap;
import java.util.Map;

public class LottoMatcher {
    private final Map<WinningInfo, Integer> winningCount;
    private final WinningLotto winningLotto;

    public LottoMatcher(WinningLotto winningLotto) {
        winningCount = new HashMap<WinningInfo, Integer>(WinningInfo.values().length);
        this.winningLotto = winningLotto;
    }

    public void startMatch(Lottoes lottoes){
        lottoes.getLottoes().forEach(lotto -> {
            WinningInfo prize = lotto.matchWithWinningLotto(winningLotto);
            winningCount.put(prize, winningCount.get(prize) + 1);
        });
    }
}
