package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public List<Lotto> purchase(int money) {
        return lottoService.purchase(money);
    }
}
