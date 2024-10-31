package lotto.domain.lottos;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Rank;
import lotto.domain.lottos.user.UserLotto;

public class RandomLottos {
    private final List<Lotto> lottos;

    public RandomLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Rank> getMatchedRank(UserLotto userLotto) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int mainLottoMatchedCount = userLotto.getMainLottoMatchedCount(lotto);
            boolean isMatchedBonus = userLotto.isContainBonusLotto(lotto);
            Rank matchedRank = Rank.findRank(mainLottoMatchedCount, isMatchedBonus);

            ranks.add(matchedRank);
        }
        return ranks;
    }

}
