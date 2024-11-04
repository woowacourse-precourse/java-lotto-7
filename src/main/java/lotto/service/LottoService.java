package lotto.service;

import lotto.model.LottoFactory;

public class LottoService {
    private final LottoFactory lottoFactory;

    public LottoService(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public void lottoInnerLogic() {
        startLotto();
    }

    private void startLotto() {

    }



}
