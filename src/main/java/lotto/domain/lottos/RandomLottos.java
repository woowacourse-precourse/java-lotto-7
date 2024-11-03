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

    public List<Rank> matchLottoAsRank(final UserLotto userLotto) {
        List<Rank> ranksResult = new ArrayList<>();

        for (Lotto lotto : lottos) {
            Rank rank = getRank(userLotto, lotto);

            if (rank.equals(Rank.NOTHING)) {
                continue;
            }
            ranksResult.add(rank);
        }
        return ranksResult;
    }

    private Rank getRank(UserLotto userLotto, Lotto lotto) {
        int mainLottoMatchedCount = userLotto.getMainLottoMatchedCount(lotto);
        boolean isMatchedBonus = userLotto.isContainBonusLotto(lotto);

        return Rank.findRank(mainLottoMatchedCount, isMatchedBonus);
    }

    public void makeLottos(int tickets) {
        for (int i = 0; i < tickets; i++) {
            lottos.add(makeOneLotto());
        }
    }

    private Lotto makeOneLotto() {
        List<Integer> randomNumbers = numbersMaker.make();
        return new Lotto(randomNumbers);
    }

    public boolean isEmptyRandomLotto() {
        return lottos.isEmpty();
    }

    public int getRandomLottoCount() {
        return lottos.size();
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
