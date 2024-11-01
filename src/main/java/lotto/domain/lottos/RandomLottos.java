package lotto.domain.lottos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lottos.user.UserLotto;

public class RandomLottos {
    private final List<Lotto> lottos;

    public RandomLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Integer, Boolean> matchLotto(UserLotto userLotto) {
        Map<Integer, Boolean> matchedResult = new HashMap<>();

        for (Lotto lotto : lottos) {
            int mainLottoMatchedCount = userLotto.getMainLottoMatchedCount(lotto);
            boolean isMatchedBonus = userLotto.isContainBonusLotto(lotto);

            matchedResult.put(mainLottoMatchedCount, isMatchedBonus);
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
