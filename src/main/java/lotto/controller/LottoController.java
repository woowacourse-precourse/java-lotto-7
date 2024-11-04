package lotto.controller;

import lotto.service.LottoServiceImpl;

public class LottoController {
    private final LottoServiceImpl lottoService;

    public LottoController(LottoServiceImpl lottoService) {
        this.lottoService = lottoService;
    }


}
