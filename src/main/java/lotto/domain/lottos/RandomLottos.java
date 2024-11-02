package lotto.domain.lottos;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Rank;
import lotto.domain.lottos.user.UserLotto;
import lotto.domain.number.NumbersMaker;

public class RandomLottos {
    private final NumbersMaker numbersMaker;
    private final List<Lotto> lottos = new ArrayList<>();

    public RandomLottos(NumbersMaker numbersMaker) {
        this.numbersMaker = numbersMaker;
    }

    public List<Rank> matchLottoAsRank(UserLotto userLotto) {
        List<Rank> ranksResult = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int mainLottoMatchedCount = userLotto.getMainLottoMatchedCount(lotto);
            boolean isMatchedBonus = userLotto.isContainBonusLotto(lotto);
            Rank rank = Rank.findRank(mainLottoMatchedCount, isMatchedBonus);

            ranksResult.add(rank);
        }
        return ranksResult;
    }

    public void makeLottos(int ticket) {
        for (int i = 0; i < ticket; i++) {
            lottos.add(makeLotto());
        }
    }

    private Lotto makeLotto() {
        List<Integer> randomNumbers = numbersMaker.make();
        return new Lotto(randomNumbers);
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
