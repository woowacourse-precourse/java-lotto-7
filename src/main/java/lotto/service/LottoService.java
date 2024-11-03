package lotto.service;

import lotto.dto.LottoStatistics;
import lotto.model.LottoShop;
import lotto.model.Lottos;
import lotto.model.WinningLotto;

public class LottoService {

    private final LottoShop lottoShop = new LottoShop();

    public Lottos buyLottos(int price) {
        return lottoShop.buy(price);
    }

    public LottoStatistics getStatistics(WinningLotto winningLotto, Lottos lottos) {
        return LottoStatistics.from(winningLotto, lottos);
    }

}
