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

    public List<Rank> findMatchedRank(UserLotto userLotto) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int mainLottoMatchedCount = userLotto.getMainLottoMatchedCount(lotto);
            boolean isMatchedBonus = userLotto.isContainBonusLotto(lotto);
            Rank matchedRank = Rank.findRank(mainLottoMatchedCount, isMatchedBonus);

            ranks.add(matchedRank);
        }
        return ranks;
    }

    @Override
    public String toString() {
        StringBuilder printout = new StringBuilder();

        for (Lotto lotto : lottos) {
            printout.append(lotto.toString());
            System.out.println(lotto + "오룸차순확인");
            printout.append("\n");
        }
        return printout.toString();
    }

}
