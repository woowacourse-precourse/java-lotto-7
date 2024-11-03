package lotto;

import java.util.List;

public class LottoManager {

    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;

    public LottoManager(final List<Lotto> lottos, final WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public List<WinningStatus> compareWinningLotto() {
        return winningLotto.compareNumbersAndBonusNumber(lottos);
    }
}
