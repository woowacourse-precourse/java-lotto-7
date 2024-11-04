package lotto;

import java.util.List;

public class LottoReferee {

    private final LottoManager lottoManager;

    public LottoReferee(final LottoManager lottoManager) {
        this.lottoManager = lottoManager;
    }

    public List<WinningStatus> judgeWinning() {
        return lottoManager.compareWinningLotto();
    }
}
