package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.GeneratedUserLottoInfo;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> userLottos;

    public Lottos(long lottoNum) {
        userLottos = new ArrayList<>();

        for (int i = 0; i < lottoNum; i++) {
            userLottos.add(new Lotto(createRandomLotto()));
        }
    }

    public GeneratedUserLottoInfo getUserLottos() {
        StringBuilder userLottoNumbers = new StringBuilder();
        userLottos.forEach(lotto -> userLottoNumbers.append(lotto.getLottoNumbers()));

        return new GeneratedUserLottoInfo(getUserLottoCount(), userLottoNumbers.toString());
    }

    public long getUserLottoCount() {
        return userLottos.size();
    }

    public void makeWinningInfo(WinningLotto winningLotto, RankingStatus rankingStatus) {
        for (Lotto userLotto : userLottos) {
            Ranking ranking = winningLotto.calculateRank(userLotto);
            rankingStatus.updateRankStatus(ranking);
        }
    }

    private List<Integer> createRandomLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
