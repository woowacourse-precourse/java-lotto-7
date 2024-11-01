package lotto.service;

import java.util.Map;
import lotto.domain.lottos.RandomLottos;
import lotto.domain.lottos.user.UserLotto;
import lotto.domain.lottos.user.WinningLotto;

public class LottoMatchService {
    private final UserLotto userLotto;
    private final RandomLottos randomLottos;
    private final WinningLotto winningLotto;

    public LottoMatchService(RandomLottos randomLottos, UserLotto userLotto, WinningLotto winningLottos) {
        this.randomLottos = randomLottos;
        this.userLotto = userLotto;
        this.winningLotto = winningLottos;
    }

    public void matchLottos() {
        Map<Integer, Boolean> matchedLottos = randomLottos.matchLotto(userLotto);
        winningLotto.addMatchedResultAsRank(matchedLottos);
    }

}
