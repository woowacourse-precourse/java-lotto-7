package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoConstants;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;

import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public Lottos generateLottos(LottoCount lottoCount) {
        List<Lotto> lottos = new ArrayList<Lotto>();

        for(int i = 0; i < lottoCount.getLottoCount(); i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE));
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }
}
