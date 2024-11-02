package lotto.controller;

import lotto.service.LottoService;
import lotto.service.dto.SellLotto;
import lotto.view.LottoView;
import lotto.view.dto.LottoBuyDTO;

public class LottoController {

    private final LottoService lottoService;
    private final LottoView lottoView;

    public LottoController(LottoService lottoService, LottoView lottoView) {
        this.lottoService = lottoService;
        this.lottoView = lottoView;
    }

    public void sellLotto(){
        LottoBuyDTO lottoBuyDTO = lottoView.lottoBuyView();
        SellLotto sellLotto = lottoService.sellLotto(lottoBuyDTO.money());

        lottoView.printSellLottos(sellLotto.lottoDetails());
    }
}
