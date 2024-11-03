package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.GeneratedUserLotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.LottoConstant.*;

public class Lottos {
    private List<Lotto> userLottos;

    public Lottos(long lottoNum) {
        userLottos = new ArrayList<>();

        for (int i = 0; i < lottoNum; i++) {
            userLottos.add(new Lotto(createRandomLotto()));
        }
    }

    public GeneratedUserLotto getUserLottos() {
        StringBuilder userLottoNumbers = new StringBuilder();
        userLottos.forEach(lotto -> userLottoNumbers.append(lotto.getLottoNumbers()));

        return new GeneratedUserLotto(getUserLottoCount(), userLottoNumbers.toString());
    }

    public long getUserLottoCount() {
        return userLottos.size();
    }

    public void calculateUserLottoResults(WinningLotto winningLotto, RankingStatus rankingStatus) {
        for (Lotto userLotto : userLottos) {
            Ranking ranking = winningLotto.calculateRank(userLotto);
            rankingStatus.updateRankStatus(ranking);
        }
    }

    private List<Integer> createRandomLotto() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER.getValue(),
                MAX_VALID_LOTTO_NUMBER.getValue(),
                VALID_LOTTO_NUMBER_COUNT.getValue()
        );
    }
}
