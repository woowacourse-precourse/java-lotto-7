package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public Lottos generateLottos(LottoCount lottoCount) {
        List<Lotto> lottos = new ArrayList<Lotto>();

        for(int i = 0; i < lottoCount.getLottoCount(); i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }
}
