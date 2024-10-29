package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(long lottoNum) {
        lottos = new ArrayList<>();

        for (int i = 0; i < lottoNum; i++) {
            lottos.add(new Lotto(createRandomLotto()));
        }
    }

    public long getUserLottoCount() {
        return lottos.size();
    }

    private List<Integer> createRandomLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
