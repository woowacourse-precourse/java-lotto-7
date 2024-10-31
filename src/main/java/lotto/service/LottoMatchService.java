package lotto.service;

import java.util.List;
import lotto.domain.Rank;
import lotto.domain.lottos.RandomLottos;
import lotto.domain.lottos.user.UserLotto;
import lotto.domain.lottos.user.WinningLottos;

public class LottoMatchService {
    private final UserLotto userLotto;
    private final RandomLottos randomLottos;
    private final WinningLottos winningLottos;

    public LottoMatchService(RandomLottos randomLottos, UserLotto userLotto, WinningLottos winningLottos) {
        this.randomLottos = randomLottos;
        this.userLotto = userLotto;
        this.winningLottos = winningLottos;
    }


    public void matchLottos() {
        List<Rank> ranksResult = randomLottos.findMatchedRank(userLotto);

        for (Rank rank : ranksResult) {
            winningLottos.addRank(rank);
        }
    }

}
