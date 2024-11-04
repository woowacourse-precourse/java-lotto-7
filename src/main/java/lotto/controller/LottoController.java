package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.dto.request.LottoMoneyRequest;
import lotto.dto.response.LottoCalculateResponse;
import lotto.dto.response.LottoNumResponseList;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public LottoNumResponseList createLotto(LottoMoneyRequest lottoMoneyRequest) {
        return lottoService.createLottoList(lottoMoneyRequest);
    }

    public LottoCalculateResponse compareLotto(Lotto answerList, int bonusNum, List<Lotto> lottoList, Money money) {
        return lottoService.calculateLotto(answerList, bonusNum, lottoList, money);
    }
}
