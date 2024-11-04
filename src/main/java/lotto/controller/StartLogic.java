package lotto.controller;

import lotto.service.LottoService;

public class StartLogic {

    private final LottoService lottoService = new LottoService();

    public void start(){

        lottoService.moneyInput();
        lottoService.setPapers();
        lottoService.winNumberInput();
        lottoService.bonusNumberInput();
        lottoService.resultOutput();

    }

}
