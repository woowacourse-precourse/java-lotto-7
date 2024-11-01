package lotto.controller;

import lotto.service.LottoService;

public class StartLogic {

    private final LottoService lottoService = new LottoService();

    public void start(){

        lottoService.userInput();
        lottoService.lotResult();

    }


}
