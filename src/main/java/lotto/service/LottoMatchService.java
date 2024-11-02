package lotto.service;

import static lotto.domain.InputErrorMessage.RANDOM_LOTTO_IS_NOT_GENERATED;

import java.util.List;
import lotto.domain.Rank;
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
        if (randomLottos.isEmptyRandomLotto()) {
            throw new IllegalStateException(RANDOM_LOTTO_IS_NOT_GENERATED.getMessage());
        }

        List<Rank> matchedResults = randomLottos.matchLottoAsRank(userLotto);
        winningLotto.addAllMatchedRank(matchedResults);
    }

}
