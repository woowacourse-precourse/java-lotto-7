package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public class LottoCheckService {

    public List<LottoRank> checkRanks(WinningLotto winningLotto, Lottos lottos) {
        List<LottoRank> ranks = new ArrayList<>();
        for (Lotto myLotto : lottos.getLottos()) {
            ranks.add(winningLotto.match(myLotto));
        }
        return ranks;
    }
}
