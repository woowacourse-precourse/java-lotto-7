package lotto.service;

import lotto.domain.Lottos;

public class LottoService {

    public Lottos generateLottos(int purchasableLottoCount) {
        return new Lottos(purchasableLottoCount);
    }
}
