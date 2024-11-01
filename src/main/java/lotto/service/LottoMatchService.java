package lotto.service;

import java.util.List;
import lotto.domain.LottoMatchedResult;
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
        List<LottoMatchedResult> matchedResults = randomLottos.matchLotto(userLotto);
        winningLotto.addMatchedResultAsRank(matchedResults);
    }

}
