package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public class LottoCheckService {

    private final Lottos myLottos;
    private final WinningLotto winningLotto;

    LottoCheckService(Lottos myLotto, WinningLotto winningLotto) {
        this.myLottos = myLotto;
        this.winningLotto = winningLotto;
    }

    public List<LottoRank> checkRanks() {
        List<LottoRank> ranks = new ArrayList<>();
        for (Lotto myLotto : myLottos.getLottos()) {
            ranks.add(winningLotto.match(myLotto));
        }
        return ranks;
    }
}
