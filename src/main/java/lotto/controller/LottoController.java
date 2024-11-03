package lotto.controller;

import lotto.dto.LottoDto;
import lotto.dto.WinningDto;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {

    private final LottoService lottoService;
    private final LottoView lottoView;


    public LottoController() {
        this.lottoService = new LottoService();
        this.lottoView = new LottoView();
    }

    public void lottoGame() {
        LottoDto start = lottoView.initLottoGame();
        WinningDto winningDto = lottoService.statisticsNumbers(start);
        lottoView.displayResults(winningDto);
    }

}
