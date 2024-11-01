package lotto.domain.lottos;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoMatchedResult;
import lotto.domain.lottos.user.UserLotto;

public class RandomLottos {
    private final List<Lotto> lottos;

    public RandomLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoMatchedResult> matchLotto(UserLotto userLotto) {
        List<LottoMatchedResult> matchedResult = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int mainLottoMatchedCount = userLotto.getMainLottoMatchedCount(lotto);
            boolean isMatchedBonus = userLotto.isContainBonusLotto(lotto);

            matchedResult.add(new LottoMatchedResult(mainLottoMatchedCount, isMatchedBonus));
        }
        return matchedResult;
    }

    @Override
    public String toString() {
        StringBuilder printout = new StringBuilder();

        for (Lotto lotto : lottos) {
            printout.append(lotto);
            printout.append("\n");
        }
        return printout.toString();
    }

}
