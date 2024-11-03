package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.LottoService;

import java.util.List;


public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public List<Lotto> purchase(int money) {
        return lottoService.purchase(money);
    }

    public LottoResult match(List<Lotto> lottos, List<Integer> winNumber, int bonusNumber) {
        return lottoService.match(lottos, winNumber, bonusNumber);
    }
}
