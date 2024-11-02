package lotto.service;

import static lotto.domain.InputErrorMessage.RANDOM_LOTTO_IS_NOT_GENERATED;

import java.util.List;
import lotto.domain.Rank;
import lotto.domain.lottos.RandomLottos;
import lotto.domain.lottos.user.UserLotto;
import lotto.domain.lottos.user.WinningRank;

public class LottoMatchService {
    private final UserLotto userLotto;
    private final RandomLottos randomLottos;
    private final WinningRank winningRank;

    public LottoMatchService(RandomLottos randomLottos, UserLotto userLotto, WinningRank winningRank) {
        this.randomLottos = randomLottos;
        this.userLotto = userLotto;
        this.winningRank = winningRank;
    }

    public void matchLottos() {
        validateRandomLottoEmpty();

        List<Rank> matchedResults = randomLottos.matchLottoAsRank(userLotto);
        winningRank.addAllMatchedRank(matchedResults);
    }


    private void validateRandomLottoEmpty() {
        if (randomLottos.isEmptyRandomLotto()) {
            throw new IllegalStateException(RANDOM_LOTTO_IS_NOT_GENERATED.getMessage());
        }
    }

}
