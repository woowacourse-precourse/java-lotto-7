package lotto.controller;

import lotto.domain.LottoStore;
import lotto.domain.Won;
import lotto.dto.LottoPaper;
import lotto.generator.RandomLottoNumberGenerator;
import lotto.view.InputView;

public class LottoController {

    public LottoPaper buy() {
        Won fee = new Won(InputView.readFee());
        LottoStore store = new LottoStore(new RandomLottoNumberGenerator());
        return store.buy(fee);
    }
}
