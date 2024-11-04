package lotto.model;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.status.LottoConstants;

import java.util.ArrayList;
import java.util.List;

public class LottoDomain implements LottoConstants {

    public Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_BALL, MAX_BALL, SIX_PICK));
    }

    public List<Lotto> createLottoBundle(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }
}
